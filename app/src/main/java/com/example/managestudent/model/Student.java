package com.example.managestudent.model;

public class Student {
    private String name;
    private int idStudent;
    private String address;
    private int courseYear;

    public Student(String name, int idStudent, String address, int courseYear) {
        this.name = name;
        this.idStudent = idStudent;
        this.address = address;
        this.courseYear = courseYear;
    }

    public String getName() {
        return name;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getAddress() {
        return address;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }
}
