package com.QuizApp.QuizApp.registration.admin;

import com.QuizApp.QuizApp.registration.student.RegistrationStudent;
import com.QuizApp.QuizApp.result.QuizResult;
import com.QuizApp.QuizApp.service.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path ="admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/adminAdd")
    public ResponseEntity<String>registrationStudent(@RequestBody RegistrationAdmin registrationAdmin){
        return adminService.registrationAdmin(registrationAdmin);
    }

    @PostMapping(path = "loginAdmin")
    public ResponseEntity<String> adminLogin(@RequestBody RegistrationAdmin registrationAdmin){
        RegistrationAdmin authenticate = adminService.loginAdmin(registrationAdmin.getEmail(),registrationAdmin.getPassword());
        if (authenticate!=null){
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Something Went to wrong",HttpStatus.UNAUTHORIZED);
        }
    }

//    @GetMapping(path = "/result")
//    public ResponseEntity<List<Object[]>> getStudentScore(@RequestParam String quizTitle){
//        List<Object[]> results = adminService.getStudentSccore(quizTitle);
//        return new ResponseEntity<>(results,HttpStatus.OK);
//    }


//    public ResponseEntity<List<ResultDTO>> getStudentScore(@RequestParam String quizId){
//        List<ResultDTO> results = adminService.getStudentSccore(quizId);
//        return new ResponseEntity<>(results,HttpStatus.OK);
//    }

}
