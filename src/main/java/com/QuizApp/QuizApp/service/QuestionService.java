package com.QuizApp.QuizApp.service;

import com.QuizApp.QuizApp.Dao.QuestionDao;
import com.QuizApp.QuizApp.Dao.QuizDataRepo;
import com.QuizApp.QuizApp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuizDataRepo quizDataRepo;

//    public ResponseEntity<String> addQuestion(Question question) {
//        questionDao.save(question);
//        return new ResponseEntity<>( "Success",HttpStatus.CREATED);
//    }


//    public QuestionDTO addQuestion(Question question) {
//        try {
//            Question question1 = questionDao.save(question);
//            return new QuestionDTO(question1.getId(),question1.getQuestionTitle(), question1.option1, question.option2,
//                    question1.option3, question1.option4, question1.rightAns, question1.category );
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new QuestionDTO(0,null,null,null,null,null,null,null);
//
//    }



    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        //return questionDao.findByCategory(category);
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public List<String> getAllCategories() {
        return questionDao.findAllCategories();
    }



}
