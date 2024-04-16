package com.QuizApp.QuizApp.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class QuestionWrapper {

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

    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
