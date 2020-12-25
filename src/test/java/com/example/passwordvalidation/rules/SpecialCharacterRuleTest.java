package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialCharacterRuleTest {
    SpecialCharacterRule characterRule;

    @BeforeEach
    void setUp() {
        characterRule = new SpecialCharacterRule("");
    }

    @Test
    void testContainSpecialCharacter(){
        final String password = "@123";

        Assertions.assertFalse(
                characterRule.validatePassword(password).isValid()
        );
    }

    @Test
    void testNotContainSpecialCharacter(){
        final String password = "123";

        Assertions.assertTrue(
                characterRule.validatePassword(password).isValid()
        );
    }

}