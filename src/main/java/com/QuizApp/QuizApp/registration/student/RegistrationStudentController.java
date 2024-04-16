package com.QuizApp.QuizApp.registration.student;

import com.QuizApp.QuizApp.entity.DTO.StudentRegDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reg")
@CrossOrigin
public class RegistrationStudentController {
    @Autowired
    private RegistrationStudentService registrationStudentService;
    @PostMapping(path = "/student")
    public ResponseEntity<String>registrationStudent(@RequestBody RegistrationStudent registrationStudent){
        return registrationStudentService.registrationStudent(registrationStudent);
    }

    @PostMapping(path = "/studentLogin")
    @CrossOrigin
    public ResponseEntity<StudentRegDTO> loginStudent(@RequestBody RegistrationStudent registrationStudent){
        StudentRegDTO studentRegDTO = registrationStudentService.studentLogin(registrationStudent.getEmail(), registrationStudent.getPassword());
        if (studentRegDTO!=null){
            return new ResponseEntity<>(studentRegDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
