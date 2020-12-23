package com.example.passwordvalidation.services;

import com.example.passwordvalidation.exception.PasswordInValidException;
import com.example.passwordvalidation.rules.Validator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService{
    private final Validator validator;

    public PasswordServiceImpl(Validator validator) {
        this.validator = validator;
    }

    public void isValidPassword(String password){
        List<String> errors = validator.validatePassword(password);
        if (errors.size() > 0){
            throw new PasswordInValidException("password validate fail",errors);
        }
    }

}
