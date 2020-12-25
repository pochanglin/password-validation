package com.example.passwordvalidation.rules;

public class DigitRule extends CharacterRule{
    public static final String DIGITS = "0123456789";
    private final int num;
    private final String errorMsg;

    public DigitRule(int num, String errorMsg) {
        this.num = num;
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {
        String matchingCharacters = getMatchingCharacters(DIGITS,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return  new ValidationResult(isValid, errorMsg);
    }
}
