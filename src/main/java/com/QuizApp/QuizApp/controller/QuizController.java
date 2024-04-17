package com.QuizApp.QuizApp.controller;


import com.QuizApp.QuizApp.entity.*;
import com.QuizApp.QuizApp.entity.DTO.QuizTitleDTO;

import com.QuizApp.QuizApp.result.QuizResult;
import com.QuizApp.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;


    @PostMapping(path = "addQuiz")
    public ResponseEntity<QuizData> createQ(@RequestBody QuizData quizData){
        return quizService.createQ(quizData);
    }

    @GetMapping(path = "getQuiz")
    public ResponseEntity<List<QuizData>> getAllQuiz(){
        return quizService.getAllQuiz();
    }
    @PostMapping("submit/{quizId}")
    public ResponseEntity<QuizResult> submitQuiz(@PathVariable Integer quizId,
                                              @RequestParam  String studentName,@RequestParam Integer  total,
                                              @RequestBody List<Response> responses){
        return quizService.calculateResult(quizId,studentName,total,responses);
    }

    @GetMapping(path = "/result/{quizId}")
    public ResponseEntity<List<QuizResult>> getQuizResult(@PathVariable Integer quizId){
        List<QuizResult> quizResult = quizService.getQuizResult(quizId);
        if (!quizResult.isEmpty()){
            return ResponseEntity.ok(quizResult);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
