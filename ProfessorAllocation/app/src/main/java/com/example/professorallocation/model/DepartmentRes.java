package com.example.professorallocation.model;

import java.util.List;

public class DepartmentRes {
    private Long id;
    private String name;
    //private List<ProfessorRes> professors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}