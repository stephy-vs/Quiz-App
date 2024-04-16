package com.QuizApp.QuizApp.result;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resultTbl")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quizName")
    private String quizName;

    @Column(name = "studentId")
    private Integer studentId;

    @Column(name = "score")
    private Integer score;

}
