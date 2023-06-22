package com.example.managestudent.model;

public class Course {
    private String name;
    private int idClass;
    private int description;
    private int term;
    private int creditUnit;

    public Course(String name, int idClass, int description, int term, int creditUnit) {
        this.name = name;
        this.idClass = idClass;
        this.description = description;
        this.term = term;
        this.creditUnit = creditUnit;
    }

    public String getName() {
        return name;
    }

    public int getIdClass() {
        return idClass;
    }

    public int getDescription() {
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

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }
}
