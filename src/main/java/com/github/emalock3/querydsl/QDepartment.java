package com.github.emalock3.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QDepartment extends com.mysema.query.sql.RelationalPathBase<Department> {

    private static final long serialVersionUID = -756142550;

    public static final QDepartment department = new QDepartment("DEPARTMENT");

    public final NumberPath<Long> companyId = createNumber("companyId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> lastModified = createDateTime("lastModified", java.sql.Timestamp.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Department> constraint4 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Company> deptCompanyFk = createForeignKey(companyId, "ID");

    public final com.mysema.query.sql.ForeignKey<Employee> _empDepartmentFk = createInvForeignKey(id, "DEPARTMENT_ID");

    public QDepartment(String variable) {
        super(Department.class, forVariable(variable), "PUBLIC", "DEPARTMENT");
        addMetadata();
    }

    public QDepartment(String variable, String schema, String table) {
        super(Department.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "DEPARTMENT");
        addMetadata();
    }

    public QDepartment(PathMetadata<?> metadata) {
        super(Department.class, metadata, "PUBLIC", "DEPARTMENT");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(companyId, ColumnMetadata.named("COMPANY_ID").ofType(-5).withSize(19).notNull());
        addMetadata(id, ColumnMetadata.named("ID").ofType(-5).withSize(19).notNull());
        addMetadata(lastModified, ColumnMetadata.named("LAST_MODIFIED").ofType(93).withSize(23).withDigits(10).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").ofType(12).withSize(2147483647).notNull());
    }

}

