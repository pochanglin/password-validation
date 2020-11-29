package com.example.passwordvalidation.services;

import com.example.passwordvalidation.exception.PasswordInValidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordServiceTest {
    @Autowired
    PasswordService passwordService;

    @Test
    void testValidPassword(){
        final String password = "foo1234";

        Assertions.assertTrue(
                passwordService.isValidPassword(password)
        );
    }

    @Test
    void testInValidPassword(){
        final String password = "FooFoo !";

        PasswordInValidException ex = Assertions.assertThrows(
                PasswordInValidException.class,
                () -> passwordService.isValidPassword(password)
        );

        Assertions.assertEquals(
                6,
                ex.getErrors().size()
        );
    }
}