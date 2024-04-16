package com.QuizApp.QuizApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "quizData")
public class QuizData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "category")
    private String category;

    @Column(name= "quizName")
    private String quizName;

    @Column(name = "timer")
    private LocalTime timer;
}
