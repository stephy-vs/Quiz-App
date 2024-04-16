package com.QuizApp.QuizApp.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDataService {
    @Autowired
    QuestionDataRepo questionDataRepo;

    public QuestionData createQtoQuiz(QuestionData questionData) {
        try {
            QuestionData questionData1 = questionDataRepo.save(questionData);
            return questionData1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public List<QuestionData> getQuestionsByQuizId(Integer quizId) {
        return questionDataRepo.findByQuizId(quizId);
    }
}
