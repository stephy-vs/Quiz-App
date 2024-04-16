package com.QuizApp.QuizApp.registration.student;

import com.QuizApp.QuizApp.registration.student.RegistrationStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationStudentRepo extends JpaRepository<RegistrationStudent,Integer> {
    RegistrationStudent findByEmailAndPassword(String email, String password);
}
