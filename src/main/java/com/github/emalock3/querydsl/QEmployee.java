package com.github.emalock3.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QEmployee extends com.mysema.query.sql.RelationalPathBase<Employee> {

    private static final long serialVersionUID = -676354170;

    public static final QEmployee employee = new QEmployee("EMPLOYEE");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> lastModified = createDateTime("lastModified", java.sql.Timestamp.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Employee> constraint7 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Department> empDepartmentFk = createForeignKey(departmentId, "ID");

    public QEmployee(String variable) {
        super(Employee.class, forVariable(variable), "PUBLIC", "EMPLOYEE");
        addMetadata();
    }

    public QEmployee(String variable, String schema, String table) {
        super(Employee.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QEmployee(Path<? extends Employee> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "EMPLOYEE");
        addMetadata();
    }

    public QEmployee(PathMetadata<?> metadata) {
        super(Employee.class, metadata, "PUBLIC", "EMPLOYEE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(departmentId, ColumnMetadata.named("DEPARTMENT_ID").ofType(-5).withSize(19).notNull());
        addMetadata(id, ColumnMetadata.named("ID").ofType(-5).withSize(19).notNull());
        addMetadata(lastModified, ColumnMetadata.named("LAST_MODIFIED").ofType(93).withSize(23).withDigits(10).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").ofType(12).withSize(2147483647).notNull());
    }

}

