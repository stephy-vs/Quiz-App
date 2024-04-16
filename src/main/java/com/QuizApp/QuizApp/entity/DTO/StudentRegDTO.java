package com.QuizApp.QuizApp.entity.DTO;

import jakarta.persistence.Column;

public class StudentRegDTO {

    private Integer id;
    private String name;

    private String course;

    private String courseYear;

    public StudentRegDTO(Integer id ,String name, String course, String courseYear) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.courseYear = courseYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }
}
