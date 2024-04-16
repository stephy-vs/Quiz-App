package com.QuizApp.QuizApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "title")
    private String title;

//    @ManyToMany
//    @Column(name = "questions")
//    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;


    @Column(name = "category")
    private String category;
}
