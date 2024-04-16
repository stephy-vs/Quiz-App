package com.QuizApp.QuizApp.result;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizResultRepo extends JpaRepository<QuizResult,Integer> {

    @Query("SELECT qr.studentId,s.name,qr.score FROM QuizResult qr JOIN RegistrationStudent s ON qr.studentId = s.id " +
            "WHERE qr.quizName = :quizTitle")
    List<Object[]> findStudentsAndScoreByQuizName(String quizTitle);
}
