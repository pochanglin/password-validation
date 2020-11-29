package com.example.passwordvalidation.controllers;

import com.example.passwordvalidation.models.Password;
import com.example.passwordvalidation.services.PasswordService;
import com.example.passwordvalidation.utils.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @PostMapping("/password/validate")
    public ResponseEntity<Object> isValidPassword(
            @RequestBody Password password){
        passwordService.isValidPassword(
           password.getPassword()
        );
        return ResponseEntityBuilder.build();
    }

}
