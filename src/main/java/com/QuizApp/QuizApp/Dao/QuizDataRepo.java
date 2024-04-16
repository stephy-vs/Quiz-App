package com.QuizApp.QuizApp.Dao;

import com.QuizApp.QuizApp.entity.QuizData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDataRepo extends JpaRepository<QuizData,Integer> {
}
