package com.example.passwordvalidation.controllers;

import com.example.passwordvalidation.exception.PasswordInValidException;
import com.example.passwordvalidation.models.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordControllerIntegrationTest {
    @Autowired
    PasswordController passwordController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testValidPassword() {
        Password password = new Password();
        password.setPassword("qll12345");

        passwordController.isValidPassword(password);
    }

    @Test
    void testInValidPassword(){
        Password password = new Password();
        password.setPassword("1234");

        Assertions.assertThrows(
                PasswordInValidException.class,
                () -> passwordController.isValidPassword(password));
    }

    @Test
    void testNullPassword(){
        Password password = null;

        Assertions.assertThrows(
                NullPointerException.class,
                () -> passwordController.isValidPassword(password));
    }

    @Test
    void testEmptyPassword(){
        Password password = new Password();
        password.setPassword("");

        Assertions.assertThrows(
                PasswordInValidException.class,
                () -> passwordController.isValidPassword(password));
    }
}