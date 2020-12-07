package com.example.passwordvalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PasswordInValidException extends RuntimeException {
    private List<String> errors;

    public PasswordInValidException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return super.toString() + errors.toString();
    }
}
