package com.QuizApp.QuizApp.service;

public class ResultDTO {
    private Integer id;
    private String name;
    private Integer score;
    private Integer total;

    public ResultDTO(Integer id, String name, Integer score, Integer total) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
