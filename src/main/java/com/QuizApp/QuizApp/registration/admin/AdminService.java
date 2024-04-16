package com.QuizApp.QuizApp.registration.admin;

import com.QuizApp.QuizApp.result.QuizResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

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

    public List<Object[]> getStudentSccore(String quizTitle) {
        return quizResultRepo.findStudentsAndScoreByQuizName(quizTitle);
    }
}
