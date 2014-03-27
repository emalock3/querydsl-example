package com.github.emalock3.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QCompany extends com.mysema.query.sql.RelationalPathBase<Company> {

    private static final long serialVersionUID = 1167261861;

    public static final QCompany company = new QCompany("COMPANY");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> lastModified = createDateTime("lastModified", java.sql.Timestamp.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Company> constraint6 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Department> _deptCompanyFk = createInvForeignKey(id, "COMPANY_ID");

    public QCompany(String variable) {
        super(Company.class, forVariable(variable), "PUBLIC", "COMPANY");
        addMetadata();
    }

    public QCompany(String variable, String schema, String table) {
        super(Company.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QCompany(Path<? extends Company> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "COMPANY");
        addMetadata();
    }

    public QCompany(PathMetadata<?> metadata) {
        super(Company.class, metadata, "PUBLIC", "COMPANY");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").ofType(-5).withSize(19).notNull());
        addMetadata(lastModified, ColumnMetadata.named("LAST_MODIFIED").ofType(93).withSize(23).withDigits(10).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").ofType(12).withSize(2147483647).notNull());
    }

}

