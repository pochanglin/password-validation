package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthRuleTest {
    LengthRule lengthRule;

    @BeforeEach
    void setUp(){
        // Must be between 5 and 12 characters in length
        lengthRule = new LengthRule("");
    }

    @Test
    void verifyLessThan() {
        final String password = "1234";
        Assertions.assertFalse(lengthRule.validate(password).isValid());
    }

    @Test
    void verifyGreaterThan() {
        String password = "0123456789123";
        Assertions.assertFalse(lengthRule.validate(password).isValid());
    }

    @Test
    void verifyBetween() {
        String password = "123456";
        Assertions.assertTrue(lengthRule.validate(password).isValid());
    }

    @Test
    void verifyContain() {
        String minPassword = "12345";
        Assertions.assertTrue(lengthRule.validate(minPassword).isValid());
        String maxPassword = "012345678912";
        Assertions.assertTrue(lengthRule.validate(maxPassword).isValid());
    }

}