package com.example.passwordvalidation.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SequenceRepeatRuleTest {
    SequenceRepeatRule sequenceRepeatRule;

    @BeforeEach
    void setUp() {
        sequenceRepeatRule = new SequenceRepeatRule("");
    }

    @Test
    void verifySequenceRepeatImmediately(){
        final String password = "foofoo1";
        Assertions.assertFalse(
                sequenceRepeatRule.validate(password).isValid()
        );
    }

    @Test
    void verifySequenceRepeatNotImmediately(){
        final String password = "foo1foo";
        Assertions.assertTrue(
                sequenceRepeatRule.validate(password).isValid()
        );
    }

}