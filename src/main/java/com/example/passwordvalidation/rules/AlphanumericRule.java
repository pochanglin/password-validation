package com.example.passwordvalidation.rules;

public class AlphanumericRule extends CharacterRule {
    private final String errorMsg;

    public AlphanumericRule(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validatePassword(String password) {

        int totalMatching = getMatchingCharacters(LOWERCASE,password,password.length()).length()
                + getMatchingCharacters(UPPERCASE,password,password.length()).length()
                + getMatchingCharacters(DIGITS,password,password.length()).length()
                + getMatchingCharacters(SPECIAL,password,password.length()).length();

        boolean isValid = totalMatching == password.length();

        return new ValidationResult(isValid,errorMsg);
    }
}
