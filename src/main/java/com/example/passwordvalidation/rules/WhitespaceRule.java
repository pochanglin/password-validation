package com.example.passwordvalidation.rules;

public class WhitespaceRule implements Rule {
    private static final boolean isContain = false;
    private final String errorMsg;

    public WhitespaceRule(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validate(String password) {

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
