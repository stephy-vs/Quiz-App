package com.QuizApp.QuizApp.entity.DTO;

import com.QuizApp.QuizApp.entity.Question;

import java.util.List;

public class QuizDTO {
    public Integer id;

    private String title;

    private List<Question> questions;

    public QuizDTO(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
