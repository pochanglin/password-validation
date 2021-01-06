package com.example.passwordvalidation.rules;

public class UppercaseRule extends CharacterRule{
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int num = 0;
    private final String errorMsg;

    public UppercaseRule(String errorMsg) {
        this.errorMsg = String.format(errorMsg,num);
    }

    @Override
    public ValidationResult validate(String password) {
        String matchingCharacters = getMatchingCharacters(UPPERCASE,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return new ValidationResult(isValid, errorMsg);
    }
}
