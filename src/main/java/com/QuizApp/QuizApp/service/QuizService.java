package com.QuizApp.QuizApp.service;

import com.QuizApp.QuizApp.Dao.QuestionDao;
import com.QuizApp.QuizApp.Dao.QuizDao;
import com.QuizApp.QuizApp.Dao.QuizDataRepo;
import com.QuizApp.QuizApp.entity.*;

import com.QuizApp.QuizApp.entity.DTO.QuizTitleDTO;
import com.QuizApp.QuizApp.question.QuestionData;
import com.QuizApp.QuizApp.question.QuestionDataRepo;
import com.QuizApp.QuizApp.result.QuizResult;
import com.QuizApp.QuizApp.result.QuizResultRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuizResultRepo quizResultRepo;

    @Autowired
    QuizDataRepo quizDataRepo;

    @Autowired
    QuestionDataRepo questionDataRepo;

    public ResponseEntity<QuizData> createQ(QuizData quizData) {
        try {
            QuizData quizData1 = quizDataRepo.save(quizData);
            return new ResponseEntity<>(quizData1,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizData>> getAllQuiz() {
        try {
            return new ResponseEntity<>(quizDataRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

//    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//
//        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);
//
//        return new ResponseEntity<>("Success", HttpStatus.CREATED);
//    }
//    public QuizDTO createQuiz(String category, int numQ, String title) {
//        try {
//            List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
//            Quiz quiz = new Quiz();
//            quiz.setTitle(title);
//            quiz.setQuestions(questions);
//            quizDao.save(quiz);
//            return new QuizDTO(quiz.getId(),quiz.getTitle(),quiz.getQuestions());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new QuizDTO(0,null,null);
//    }
//    public QuizDTO createQuiz1(String category, String title, List<Question> questions) {
//       try {
//           Quiz quiz = new Quiz();
//           quiz.setCategory(category);
//           quiz.setTitle(title);
//           quiz.setQuestions(questions);
//           Quiz quiz1 = quizDao.save(quiz);
//           return new QuizDTO(quiz1.getId(), quiz1.getTitle(), quiz1.getQuestions());
//       }catch (DataAccessException e){
//           e.printStackTrace();
//       }
//       return new QuizDTO(0,null,null);
//    }




//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questionsFromDB = quiz.get().getQuestions();
//        List<QuestionWrapper> questionsForUser = new ArrayList<>();
//        for (Question q : questionsFromDB){
//            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),
//                    q.getOption3(),q.getOption4());
//            questionsForUser.add(qw);
//        }
//        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
//    }


//    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//        Quiz quiz = quizDao.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
//        int right =0; int i =0;
//        for (Response response : responses){
//            if (response.getResponse().equals(questions.get(i).getRightAns())){
//                right++;
//            }
//            i++;
//        }
//        return new ResponseEntity<>(right,HttpStatus.OK);
//    }


//    public List<String> getAllQuizTitles() {
//        List<Quiz> quizzes = quizDao.findAll();
//        List<String> titles = new ArrayList<>();
//        for (Quiz quiz : quizzes){
//            titles.add(quiz.getTitle());
//        }
//        return titles;
//    }

//    public ResponseEntity<QuizResult> calculateResult(Integer studentId, String title, Integer id,
//                                                   List<Response> responses) {
//        Quiz quiz = quizDao.findById(id).get();
//       // List<Question> questions = quiz.getQuestions();
//        int right =0; int i =0;
//        for (Response response : responses){
//            if (response.getResponse().equals(questions.get(i).getRightAns())){
//                right++;
//            }
//            i++;
//        }
//    }




    public List<QuizTitleDTO> getAllQuizes() {
        List<Quiz> quizzes = quizDao.findAll();
        List<QuizTitleDTO> titles = new ArrayList<>();
        for (Quiz quiz : quizzes){
            QuizTitleDTO quizTitleDTO = new QuizTitleDTO(quiz.getId(), quiz.getTitle());
            titles.add(quizTitleDTO);
        }
        return titles;
    }

    public ResponseEntity<Integer> calculateResult(Integer quizId, List<Response> responses) {
        int score =0;
        List<QuestionData> questionData = questionDataRepo.findByQuizId(quizId);
        for (Response response : responses){
            QuestionData questionData1 =findQuestionByID(questionData,response.getId());
            if (questionData1 != null && questionData1.getRightAns().equals(response.getResponse())){
                score++;
            }
        }
        return ResponseEntity.ok(score);
    }

    private QuestionData findQuestionByID(List<QuestionData> questionData, Integer id) {
        for (QuestionData questionData1 : questionData){
            if (questionData1.getId().equals(id));
            return questionData1;
        }
        return null;
    }
}
