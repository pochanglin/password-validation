package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UppercaseRuleTest {
    UppercaseRule uppercaseRule;
    UppercaseRule noUppercaseRule;

    @BeforeEach
    void setUp() {
        uppercaseRule = new UppercaseRule(1,"");
        noUppercaseRule = new UppercaseRule(0,"");
    }

    @Test
    void testContainUppercase(){
        final String password = "Foo1";

        Assertions.assertTrue(
                uppercaseRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNotContainUppercase(){
        final String password = "foo1";

        Assertions.assertFalse(
                uppercaseRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNoUppercaseRule(){
        final String password = "Foo1";

        Assertions.assertFalse(
                noUppercaseRule.validatePassword(password).isValid()
        );
    }
}