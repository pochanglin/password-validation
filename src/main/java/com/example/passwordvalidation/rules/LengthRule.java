package com.example.passwordvalidation.rules;

public class LengthRule implements IPasswordValidationRule {
    private static final int minLength = 5;
    private static final int maxLength = 12;
    private final String errorMsg;

    public LengthRule(String errorMsg) {
        this.errorMsg = String.format(errorMsg,minLength,maxLength);
    }

    @Override
    public ValidationResult validatePassword(String password) {
        int length = password.length();
        boolean result = length >= minLength && length <= maxLength;
        return new ValidationResult(result ,errorMsg);
    }
}
