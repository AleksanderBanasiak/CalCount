package com.banasiak.CalCount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DayNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(DayNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String dayNotFoundHandler(DayNotFoundException e){
        return e.getMessage();
    }
}
