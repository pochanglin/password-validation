package com.example.passwordvalidation.rules;

public class LengthRule implements IPasswordValidationRule {
    private final int minLength;
    private final int maxLength;
    private final String errorMsg;

    public LengthRule(int minLength, int maxLength, String errorMsg) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {
        int length = password.length();
        boolean result = length >= minLength && length <= maxLength;
        return new ValidationResult(result ,errorMsg);
    }
}
