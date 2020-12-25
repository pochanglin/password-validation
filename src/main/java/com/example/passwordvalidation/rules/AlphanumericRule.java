package com.example.passwordvalidation.rules;

public class AlphanumericRule extends CharacterRule {
    private final String errorMsg;

    public AlphanumericRule(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {
        final int len = password.length();

        int totalMatching = LowercaseRule.getMatchingCharacters(LowercaseRule.LOWERCASE,password,len).length()
                        + UppercaseRule.getMatchingCharacters(UppercaseRule.UPPERCASE,password,len).length()
                        + DigitRule.getMatchingCharacters(DigitRule.DIGITS,password,len).length()
                        + SpecialCharacterRule.getMatchingCharacters(SpecialCharacterRule.SPECIAL,password,len).length();

        return new ValidationResult(
                totalMatching == len,
                errorMsg
        );
    }
}
