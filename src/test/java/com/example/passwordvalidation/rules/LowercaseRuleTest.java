package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowercaseRuleTest {
    LowercaseRule lowercaseRule;
    LowercaseRule noLowercaseRule;

    @BeforeEach
    void setUp(){
        lowercaseRule = new LowercaseRule(1,"");
        noLowercaseRule = new LowercaseRule(0, "");
    }

    @Test
    void testContainLowercase(){
        final String password = "p123";

        Assertions.assertTrue(
                lowercaseRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNotContainLowercase(){
        final String password = "P123";

        Assertions.assertFalse(
                lowercaseRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNoLowercaseRule(){
        final String password = "p123";

        Assertions.assertFalse(
                noLowercaseRule.validatePassword(password).isValid()
        );
    }
}