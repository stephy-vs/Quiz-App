package com.QuizApp.QuizApp.registration.student;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="regStudent")
public class RegistrationStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId")
    private Integer StudentId;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private String course;

    @Column(name = "courseYear")
    private String courseYear;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public RegistrationStudent() {
    }

    public RegistrationStudent(Integer studentId, String name, String course, String courseYear) {
        StudentId = studentId;
        this.name = name;
        this.course = course;
        this.courseYear = courseYear;
    }
}
