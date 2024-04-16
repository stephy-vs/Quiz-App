package com.QuizApp.QuizApp.category;

public class CategoryDTO {
    private Integer id;
    private String subject;

    public CategoryDTO(Integer id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
