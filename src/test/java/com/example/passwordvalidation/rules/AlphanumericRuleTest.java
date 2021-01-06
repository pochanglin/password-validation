package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlphanumericRuleTest {
    AlphanumericRule alphanumericRule;

    @BeforeEach
    void setUp() {
        alphanumericRule = new AlphanumericRule("");
    }

    @Test
    void testContainNonAlphanumericCharacter(){
        final String password = "foo1234我";

        Assertions.assertFalse(
                alphanumericRule.validate(password).isValid()
        );
    }

    @Test
    void testNotContainNonAlphanumericCharacter(){
        final String password = "foo1234!@";

        Assertions.assertTrue(
                alphanumericRule.validate(password).isValid()
        );
    }
}