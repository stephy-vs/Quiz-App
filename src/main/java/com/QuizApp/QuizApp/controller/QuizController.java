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
    //@PostMapping("create")
//    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
//        return quizService.createQuiz(category,numQ,title);
//    }

//    public ResponseEntity<QuizDTO> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
//        QuizDTO quizDTO = quizService.createQuiz(category,numQ,title);
//        return new ResponseEntity<>(quizDTO, HttpStatus.CREATED);
//    }


    @GetMapping("titles")
//    public ResponseEntity<List<String>> getAllQuizTitles(){
//        List<String> titles = quizService.getAllQuizTitles();
//        return new ResponseEntity<>(titles,HttpStatus.OK);
//    }
    public ResponseEntity<Map<Integer,String>> getAllTitlesAndIds(){
        List<QuizTitleDTO> quizTitleDTOList = quizService.getAllQuizes();
        Map<Integer,String> titleIdMap = new HashMap<>();
        for (QuizTitleDTO quizTitleDTO : quizTitleDTOList){
            titleIdMap.put(quizTitleDTO.getId(), quizTitleDTO.getTitle());
        }
        return new ResponseEntity<>(titleIdMap,HttpStatus.OK);
    }

//    @GetMapping("get/{id}")
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
//        return quizService.getQuizQuestions(id);
//    }

    //@PostMapping("submit/{id}")
//
//    public ResponseEntity<QuizResult> submitQuiz(@RequestParam Integer studentId, @RequestParam String title,
//                                                 @RequestParam String category,@PathVariable Integer id,
//                                                 @RequestBody List<Response> responses){
//        return quizService.calculateResult(studentId,title,category,id,responses);
//    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer quizId, @RequestBody List<Response> responses){
        return quizService.calculateResult(quizId,responses);
    }
}
