package com.example.passwordvalidation.rules;

public class LowercaseRule extends CharacterRule{
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final int num = 1;
    private final String errorMsg;

    public LowercaseRule(String errorMsg) {
        this.errorMsg = String.format(errorMsg,num);
    }

    @Override
    public ValidationResult validatePassword(String password) {
        String matchingCharacters = getMatchingCharacters(LOWERCASE,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return new ValidationResult(isValid, errorMsg);
    }
}
