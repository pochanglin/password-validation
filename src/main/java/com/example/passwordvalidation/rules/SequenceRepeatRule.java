package com.example.passwordvalidation.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceRepeatRule implements Rule {
    private final Pattern pattern = Pattern.compile("(\\w{2,})\\1");
    private final String errorMsg;

    public SequenceRepeatRule(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public ValidationResult validate(String password) {
        Matcher matcher = pattern.matcher(password);
        return new ValidationResult(
                !matcher.find(),
                errorMsg
        );
    }
}
