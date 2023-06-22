package com.example.managestudent.model;

public class Course {
    private int idCourse;
    private String name;
    private int term;
    private int creditUnit;
    private String description;


    public Course(int idCourse, String name, String description, int term, int creditUnit) {
        this.idCourse = idCourse;
        this.name = name;
        this.description = description;
        this.term = term;
        this.creditUnit = creditUnit;
    }

    public String getName() {
        return name;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public String getDescription() {
        return description;
    }

    public int getTerm() {
        return term;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
