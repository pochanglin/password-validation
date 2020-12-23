package com.example.passwordvalidation.services;

import com.example.passwordvalidation.exception.PasswordInValidException;
import com.example.passwordvalidation.rules.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


class PasswordServiceTest {
    Validator validator;

    PasswordService passwordService;

    @BeforeEach
    void setUp(){
        validator = Mockito.mock(Validator.class);
        passwordService = new PasswordServiceImpl(validator);
    }

    @Test
    void testNotThrowException(){
        final String password = "";

        Mockito.when(validator.validatePassword(password))
                .thenReturn(new ArrayList<>());

        Assertions.assertDoesNotThrow(
                () -> passwordService.isValidPassword(password)
        );
    }

    @Test
    void testThrowException(){
        final String password = "";

        List<String> errors = new ArrayList<>();
        errors.add("this is mock error!");

        Mockito.when(validator.validatePassword(password))
                .thenReturn(errors);

        Assertions.assertThrows(
                PasswordInValidException.class,
                () -> passwordService.isValidPassword(password)
        );
    }
}