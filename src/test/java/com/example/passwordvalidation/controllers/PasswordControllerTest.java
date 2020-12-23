package com.example.passwordvalidation.controllers;

import com.example.passwordvalidation.exception.PasswordInValidException;
import com.example.passwordvalidation.models.Password;
import com.example.passwordvalidation.services.PasswordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

class PasswordControllerTest {
    PasswordService passwordService;
    PasswordController passwordController;

    @BeforeEach
    void setUp() {
        passwordService = Mockito.mock(PasswordService.class);
        passwordController = new PasswordController(passwordService);
    }

    @Test
    void isValidPassword() {
        Password password = new Password();
        password.setPassword("123");

        ResponseEntity<Object> responseEntity = passwordController.isValidPassword(password);

        Assertions.assertEquals(
                responseEntity.getStatusCodeValue(),
                200
        );
    }

    @Test
    void isValidPasswordEmpty(){
        Password password = new Password();
        password.setPassword("");

        Assertions.assertThrows(
                PasswordInValidException.class,
                () -> passwordController.isValidPassword(password)
        );
    }
}