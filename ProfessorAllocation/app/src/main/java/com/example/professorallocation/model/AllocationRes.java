package com.example.professorallocation.model;

import java.util.ArrayList;
import java.util.List;

public class AllocationRes {
    private Long id;
    private String dayOfWeek;
    private String startHour;
    private String endHour;
    private ProfessorRes professor;
    private CourseRes course;


    public ProfessorRes getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorRes professor) {
        this.professor = professor;
    }

    public CourseRes getCourse() {
        return course = course;
    }

    public void setCourse(CourseRes course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

}