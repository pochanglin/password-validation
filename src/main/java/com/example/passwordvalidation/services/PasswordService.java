package com.example.passwordvalidation.services;

import com.example.passwordvalidation.exception.PasswordInValidException;
import com.example.passwordvalidation.rules.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasswordService {
    @Autowired
    Validator validator;

    public boolean isValidPassword(String password){
        List<String> errors = validator.validatePassword(password);
        if (errors.size() > 0){
            throw new PasswordInValidException("password validate fail",errors);
        }
        return true;
    }

}
