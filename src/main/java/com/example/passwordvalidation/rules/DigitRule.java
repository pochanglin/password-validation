package com.example.passwordvalidation.rules;

public class DigitRule extends CharacterRule{
    public static final String DIGITS = "0123456789";
    private static final int num = 1;
    private final String errorMsg;

    public DigitRule(String errorMsg) {
        this.errorMsg = String.format(errorMsg,num);
    }

    @Override
    public ValidationResult validate(String password) {
        String matchingCharacters = getMatchingCharacters(DIGITS,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return  new ValidationResult(isValid, errorMsg);
    }
}
