package com.example.passwordvalidation.rules;

public class SpecialCharacterRule extends CharacterRule {
    public static final String SPECIAL = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final int num = 0;
    private final String errorMsg;

    public SpecialCharacterRule(String errorMsg) {
        this.errorMsg = String.format(errorMsg,num);
    }

    @Override
    public ValidationResult validate(String password) {
        String matchingCharacters = getMatchingCharacters(SPECIAL,password,password.length());

        boolean isValid = checkResult(num,matchingCharacters);

        return new ValidationResult(isValid, errorMsg);
    }
}
