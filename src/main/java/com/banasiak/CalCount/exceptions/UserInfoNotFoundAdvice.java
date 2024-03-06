package com.banasiak.CalCount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserInfoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MealNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userInfoNotFoundHandler(UserInfoNotFoundException e){
        return e.getMessage();
    }
}
