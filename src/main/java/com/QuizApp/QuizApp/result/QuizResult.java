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

    @Column(name = "quizId")
    private Integer quizId;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "score")
    private Integer score;

    @Column(name = "total")
    private Integer total;

}
