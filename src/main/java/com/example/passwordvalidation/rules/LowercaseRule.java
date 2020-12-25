package com.example.passwordvalidation.rules;

public class LowercaseRule extends CharacterRule{
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final int num;
    private final String errorMsg;

    public LowercaseRule(int num, String errorMsg) {
        this.num = num;
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {
        String matchingCharacters = getMatchingCharacters(LOWERCASE,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return new ValidationResult(isValid, errorMsg);
    }
}
