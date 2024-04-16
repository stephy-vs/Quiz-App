package com.QuizApp.QuizApp.question;

import com.QuizApp.QuizApp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Question")
public class QuestionDataController {
    @Autowired
    QuestionDataService questionDataService;

    @PostMapping(path = "addQ")
    public ResponseEntity<QuestionData>  createQtoQuiz(@RequestBody QuestionData questionData){
        QuestionData questionData1 = questionDataService.createQtoQuiz(questionData);
        return new  ResponseEntity<>(questionData1, HttpStatus.OK);
    }

    @GetMapping(path = "quizId/{quizId}")
    public ResponseEntity<List<QuestionData>> getQuestionByQuizId(@PathVariable Integer quizId){
        List<QuestionData> questionData = questionDataService.getQuestionsByQuizId(quizId);
        if (questionData.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(questionData,HttpStatus.OK);
    }



}
