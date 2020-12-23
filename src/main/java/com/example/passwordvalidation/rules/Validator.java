package com.example.passwordvalidation.rules;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Validator {
    private final List<IPasswordValidationRule> passwordValidationRules;

    public Validator(List<IPasswordValidationRule> passwordValidationRules) {
        this.passwordValidationRules = passwordValidationRules;
    }

    public List<String> validatePassword(String password){
        List<ValidationResult> results = new ArrayList<>();
        for (IPasswordValidationRule rule : passwordValidationRules){
            ValidationResult vr = rule.validatePassword(password);
            results.add(vr);
        }

        List<String> errors = new ArrayList<>();
        results.forEach(result -> {
            if (!result.isValid()) errors.add(result.getErrorMsg());
        });

        return errors;
    }

}
