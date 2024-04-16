package com.QuizApp.QuizApp.controller;

import com.QuizApp.QuizApp.entity.Question;
import com.QuizApp.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

   // @PostMapping("/add")
//    public ResponseEntity<String> addQuestion(@RequestBody Question question){
//        return questionService.addQuestion(question);
//    }
//    public ResponseEntity<Question> addQuestion(@PathVariable Integer id,@RequestBody Question question){
//        Question question1 = questionService.addQuestion(id,question);
//        return new ResponseEntity<>(question1,HttpStatus.OK);
//    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<String>> getAllCategories(){
        List<String> categories = questionService.getAllCategories();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(categories,HttpStatus.OK);
        }
    }
}
