package ua.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by admin on 7/11/2017.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<?> handle(DataIntegrityViolationException e){
        System.out.println(e.getMessage());
        return ResponseEntity.status(400).body("department with this name already exist");
    }

}
