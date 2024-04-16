package com.QuizApp.QuizApp.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDataRepo extends JpaRepository<QuestionData,Integer> {

    List<QuestionData> findByQuizId(Integer quizId);
}
