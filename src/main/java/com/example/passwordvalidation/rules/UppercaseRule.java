package com.example.passwordvalidation.rules;

public class UppercaseRule extends CharacterRule{
    private final int num;
    private final String errorMsg;

    public UppercaseRule(int num, String errorMsg) {
        this.num = num;
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {
        String matchingCharacters = getMatchingCharacters(UPPERCASE,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return new ValidationResult(isValid, errorMsg);
    }
}
