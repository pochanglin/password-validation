package com.example.passwordvalidation.rules;

public class AlphanumericRule extends CharacterRule {
    private final String errorMsg;

    public AlphanumericRule(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validate(String password) {
        final int len = password.length();

        int totalMatching = getMatchingCharacters(LowercaseRule.LOWERCASE,password,len).length()
                            + getMatchingCharacters(UppercaseRule.UPPERCASE,password,len).length()
                            + getMatchingCharacters(DigitRule.DIGITS,password,len).length()
                            + getMatchingCharacters(SpecialCharacterRule.SPECIAL,password,len).length();

        return new ValidationResult(
                totalMatching == len,
                errorMsg
        );
    }
}
