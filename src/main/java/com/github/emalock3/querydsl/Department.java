package com.github.emalock3.querydsl;

import javax.annotation.Generated;

/**
 * Department is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Department {

    private Long companyId;

    private Long id;

    private java.sql.Timestamp lastModified;

    private String name;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(java.sql.Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

