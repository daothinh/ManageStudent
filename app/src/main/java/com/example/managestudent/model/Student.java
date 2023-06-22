package com.example.managestudent.model;

public class Student {
    private int idStudent;
    private String name;
    private String dob;
    private String address;
    private int courseYear;

    public Student(int idStudent, String name, String dob, String address, int courseYear) {
        this.idStudent = idStudent;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.courseYear = courseYear;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }
}
