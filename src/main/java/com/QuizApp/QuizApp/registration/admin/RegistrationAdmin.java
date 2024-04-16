package com.QuizApp.QuizApp.registration.admin;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "adminTbl")
public class RegistrationAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
