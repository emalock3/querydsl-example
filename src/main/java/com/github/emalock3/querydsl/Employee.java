package com.github.emalock3.querydsl;

import javax.annotation.Generated;

/**
 * Employee is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Employee {

    private Long departmentId;

    private Long id;

    private java.sql.Timestamp lastModified;

    private String name;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

