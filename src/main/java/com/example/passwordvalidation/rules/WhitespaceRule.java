package com.example.passwordvalidation.rules;

public class WhitespaceRule implements IPasswordValidationRule {
    private final boolean isContain;
    private final String errorMsg;

    public WhitespaceRule(boolean isContain, String errorMsg) {
        this.isContain = isContain;
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {

        boolean result = false;
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isWhitespace(c)){
                result = true;
                break;
            }
        }

        boolean isValid = isContain == result;

        return new ValidationResult(isValid,errorMsg);
    }

}
