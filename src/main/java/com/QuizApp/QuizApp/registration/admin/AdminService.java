package com.QuizApp.QuizApp.registration.admin;

import com.QuizApp.QuizApp.registration.student.RegistrationStudent;
import com.QuizApp.QuizApp.registration.student.RegistrationStudentRepo;
import com.QuizApp.QuizApp.result.QuizResult;
import com.QuizApp.QuizApp.result.QuizResultRepo;
import com.QuizApp.QuizApp.service.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    RegistrationStudentRepo registrationStudentRepo;

    @Autowired
    private QuizResultRepo quizResultRepo;
    public RegistrationAdmin loginAdmin(String email, String password) {
        return adminRepo.findByEmailAndPassword(email,password);
    }

    public ResponseEntity<String> registrationAdmin(RegistrationAdmin registrationAdmin) {
        try {

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Something went to wrong",HttpStatus.BAD_REQUEST);
        }
         adminRepo.save(registrationAdmin);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

//    public List<ResultDTO> getStudentSccore(String quizId) {
//        List<Object[]> results = quizResultRepo.findStudentsAndScoreByQuizName(quizId);
//        return results.stream().map(result -> {
//            Integer studentId =(Integer) result[0];
//        String name = (String) result[1];
//        Integer score = (Integer) result[2];
//            Integer total = null;
//            if (result.length>3){
//                total = (Integer) result[3];
//            }
//
//            //RegistrationStudent student = registrationStudentRepo.findById(studentId).orElse(null);
//
//            return new ResultDTO(studentId,name,score,total);
//        }).collect(Collectors.toList());
//
//    }



//    public List<Object[]> getStudentSccore(String quizTitle) {
//        return quizResultRepo.findStudentsAndScoreByQuizName(quizTitle);
//    }
}
