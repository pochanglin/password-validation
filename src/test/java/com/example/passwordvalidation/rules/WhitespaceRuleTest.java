package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhitespaceRuleTest {
    WhitespaceRule whitespaceRule;

    @BeforeEach
    void setUp() {
        whitespaceRule = new WhitespaceRule("");
    }

    @Test
    void verifyWhitespaceContain(){
        String password = "m mon";
        Assertions.assertFalse(
                whitespaceRule.validate(password).isValid()
        );
    }

    @Test
    void verifyWhitespaceNotContain(){
        String password = "m0mon";
        Assertions.assertTrue(
                whitespaceRule.validate(password).isValid()
        );
    }
}