package com.example.passwordvalidation.rules;

public class SpecialCharacterRule extends CharacterRule {
    private final int num;
    private final String errorMsg;

    public SpecialCharacterRule(int num, String errorMsg) {
        this.num = num;
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {
        String matchingCharacters = getMatchingCharacters(SPECIAL,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return new ValidationResult(isValid, errorMsg);
    }
}
