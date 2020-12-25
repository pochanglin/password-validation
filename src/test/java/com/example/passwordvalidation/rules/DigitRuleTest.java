package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DigitRuleTest {
    DigitRule digitRule;

    @BeforeEach
    void setUp(){
        digitRule = new DigitRule("");
    }

    @Test
    void testContainDigit(){
        final String password = "foo2";

        Assertions.assertTrue(
                digitRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNotContainDigit(){
        final String password = "foo";

        Assertions.assertFalse(
                digitRule.validatePassword(password).isValid()
        );
    }
}