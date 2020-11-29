package com.example.passwordvalidation.utils;

import com.example.passwordvalidation.exception.ApiError;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {

    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    public static ResponseEntity<Object> build(){
        return ResponseEntity.ok().build();
    }

}
