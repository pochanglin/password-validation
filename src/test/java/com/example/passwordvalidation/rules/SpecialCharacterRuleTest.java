package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialCharacterRuleTest {
    SpecialCharacterRule characterRule;
    SpecialCharacterRule noCharacterRule;

    @BeforeEach
    void setUp() {
        characterRule = new SpecialCharacterRule(1,"");
        noCharacterRule = new SpecialCharacterRule(0,"");
    }

    @Test
    void testContainSpecialCharacter(){
        final String password = "@123";

        Assertions.assertTrue(
                characterRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNotContainSpecialCharacter(){
        final String password = "123";

        Assertions.assertFalse(
                characterRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNoSpecialCharacterRule(){
        final String password = "@123";

        Assertions.assertFalse(
                noCharacterRule.validatePassword(password).isValid()
        );
    }
}