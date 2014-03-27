package com.github.emalock3.querydsl;

import com.mysema.commons.lang.CloseableIterator;
import com.mysema.query.Tuple;
import com.mysema.query.sql.Configuration;
import com.mysema.query.sql.H2Templates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLDeleteClause;
import com.mysema.query.sql.dml.SQLInsertClause;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QEmployeeTest {

    private Connection conn;
    private SQLTemplates templates;
    private Configuration configuration;

    @Before
    public void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/querydsl_ex;MVCC=TRUE", "sa", "");
        conn.setAutoCommit(false);
        templates = new H2Templates();
        configuration = new Configuration(templates);
    }

    @After
    public void tearDown() throws SQLException {
        configuration = null;
        templates = null;
        if (conn != null) {
            conn.rollback();
            conn.close();
        }
    }

    @Test
    public void testInsert() throws SQLException {
        QCompany com = new QCompany("com");
        new SQLDeleteClause(conn, configuration, com).execute();
        SQLInsertClause insertCom = new SQLInsertClause(conn, configuration, com);
        IntStream.range(0, 10).forEach(i -> {
            insertCom.columns(com.name, com.lastModified)
                .values(String.format("company-%d", i), new Date()).addBatch();
        });
        insertCom.execute();
        List<Long> companyIds = query().from(com).list(com.id);
        QDepartment dept = new QDepartment("dept");
        SQLInsertClause insertDept = new SQLInsertClause(conn, configuration, dept);
        IntStream.range(0, 20).forEach(i -> {
            insertDept.columns(dept.companyId, dept.name, dept.lastModified)
                    .values(companyIds.get((int) (Math.random() * companyIds.size())), 
                            String.format("department-%d", i), new Date())
                    .addBatch();
        });
        insertDept.execute();
        List<Long> deptIds = query().from(dept).list(dept.id);
        QEmployee emp = new QEmployee("emp");
        SQLInsertClause insertEmp = new SQLInsertClause(conn, configuration, emp);
        IntStream.range(0, 100).forEach(i -> {
            insertEmp.columns(emp.departmentId, emp.name, emp.lastModified)
                    .values(deptIds.get((int) (Math.random() * deptIds.size())), 
                            String.format("emp-%d", i), new Date())
                    .addBatch();
        });
        insertEmp.execute();
        query().from(com).list(com.all()).stream().forEach(System.out::println);
        CloseableIterator<Tuple> iterate = query().from(emp)
                .leftJoin(dept).on(dept.id.eq(emp.departmentId))
                .leftJoin(com).on(com.id.eq(dept.companyId))
                .where(emp.id.mod(2L).eq(0L))
                .orderBy(com.id.asc(), dept.id.asc(), emp.id.asc())
                .iterate(com.id, com.name, dept.id, dept.name, emp.id, emp.name, emp.lastModified);
        toStream(iterate)
                .filter(row -> row.get(emp.id) % 4 == 0)
                .forEach(System.out::println);
    }
    
    private Stream<Tuple> toStream(Iterator<Tuple> iterate) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iterate, Spliterator.NONNULL | Spliterator.IMMUTABLE), false);
    }
    
    private SQLQuery query() {
        return new SQLQuery(conn, configuration);
    }

}
