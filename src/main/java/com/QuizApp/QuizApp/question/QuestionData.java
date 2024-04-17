package com.QuizApp.QuizApp.question;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "questionTbl")
public class QuestionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "questionTitle")
    private String questionTitle;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "rightAns")
    private String rightAns;

    @Column(name = "quizId")
    private Integer quizId;

}
