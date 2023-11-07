package com.QuizApp.QuizApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity()
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "questionTitle")
    public String questionTitle;

    @Column(name = "option1")
    public String option1;

    @Column(name = "option2")
    public String option2;

    @Column(name = "option3")
    public String option3;

    @Column(name = "option4")
    public String option4;

    @Column(name = "rightAns")
    public String rightAns;

    @Column(name = "category")
    public String category;

}
