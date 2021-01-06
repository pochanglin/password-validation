package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowercaseRuleTest {
    LowercaseRule lowercaseRule;

    @BeforeEach
    void setUp(){
        lowercaseRule = new LowercaseRule("");
    }

    @Test
    void testContainLowercase(){
        final String password = "p123";

        Assertions.assertTrue(
                lowercaseRule.validate(password).isValid()
        );
    }

    @Test
    void testNotContainLowercase(){
        final String password = "P123";

        Assertions.assertFalse(
                lowercaseRule.validate(password).isValid()
        );
    }
}