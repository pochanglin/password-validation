package com.example.passwordvalidation.rules;

public interface IPasswordValidationRule {

    ValidationResult validatePassword(String password);

}
