package com.example.passwordvalidation.exception;

import com.example.passwordvalidation.utils.ResponseEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PasswordInValidException.class)
    protected ResponseEntity<Object> handlePasswordInValidException(
            PasswordInValidException exception){
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(exception.getMessage());
        apiError.setErrors(
                exception.getErrors()
        );
        return ResponseEntityBuilder.build(apiError);
    }

}
