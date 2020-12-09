package com.example.passwordvalidation.controllers;

import com.example.passwordvalidation.exception.PasswordInValidException;
import com.example.passwordvalidation.models.Password;
import com.example.passwordvalidation.services.PasswordService;
import com.example.passwordvalidation.utils.ResponseEntityBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/password/validate")
    public ResponseEntity<Object> isValidPassword(
            @RequestBody Password password){
        if (StringUtils.isEmpty(password.getPassword())){
            throw new PasswordInValidException("password is null", new ArrayList<>());
        }
        passwordService.isValidPassword(
           password.getPassword()
        );
        return ResponseEntityBuilder.build();
    }

}
