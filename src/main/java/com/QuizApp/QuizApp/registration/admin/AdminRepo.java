package com.QuizApp.QuizApp.registration.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<RegistrationAdmin,Integer> {
    RegistrationAdmin findByEmailAndPassword(String email, String password);
}
