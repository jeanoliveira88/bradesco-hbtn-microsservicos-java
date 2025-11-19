package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {
    @ExceptionHandler
    ResponseEntity<CPFException> handleException(CPFException err){
        UserErrorResponse user = new UserErrorResponse();
        user.setStatus(HttpStatus.BAD_REQUEST.value());
        user.setMessage("You have entered CPF "+err.getMessage()+" invalid.");
        return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity handleException(UserIdException err){
        UserErrorResponse user = new UserErrorResponse();
        user.setStatus(HttpStatus.BAD_REQUEST.value());
        user.setMessage("You have entered invalid ID "+err.getMessage()+" invalid.");
        return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<UserNameException> handleException(UserNameException err){
        UserErrorResponse user = new UserErrorResponse();
        user.setStatus(HttpStatus.BAD_REQUEST.value());
        user.setMessage("You have entered invalid USERNAME "+err.getMessage()+" invalid.");
        return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
    }
}
