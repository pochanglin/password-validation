package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UppercaseRuleTest {
    UppercaseRule uppercaseRule;

    @BeforeEach
    void setUp() {
        uppercaseRule = new UppercaseRule("");
    }

    @Test
    void testContainUppercase(){
        final String password = "Foo1";

        Assertions.assertFalse(
                uppercaseRule.validate(password).isValid()
        );
    }

    @Test
    void testNotContainUppercase(){
        final String password = "foo1";

        Assertions.assertTrue(
                uppercaseRule.validate(password).isValid()
        );
    }
}