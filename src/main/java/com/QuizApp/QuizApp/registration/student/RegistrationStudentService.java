package com.QuizApp.QuizApp.registration.student;

import com.QuizApp.QuizApp.entity.DTO.StudentRegDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationStudentService {
    @Autowired
    private RegistrationStudentRepo registrationStudentRepo;
    public ResponseEntity<String> registrationStudent(RegistrationStudent registrationStudent) {
        try {
            registrationStudentRepo.save(registrationStudent);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public StudentRegDTO studentLogin(String email, String password) {
        try {
            RegistrationStudent registrationStudent = registrationStudentRepo.findByEmailAndPassword(email, password);
            return new StudentRegDTO(registrationStudent.getStudentId(), registrationStudent.getName(),registrationStudent.getCourse(),registrationStudent.getCourseYear());
        }catch (Exception e){
            e.printStackTrace();
        }
        return new StudentRegDTO(0,null,null,null);
    }

//    public RegistrationStudent studentLogin(String email, String password) {
//       return registrationStudentRepo.findByEmailAndPassword(email,password);
//    }
}
