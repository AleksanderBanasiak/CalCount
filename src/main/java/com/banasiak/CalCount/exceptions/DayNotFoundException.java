package com.banasiak.CalCount.exceptions;

public class DayNotFoundException extends RuntimeException{

    public DayNotFoundException(Long id) {
        super("Could not find day:" +id);

    }

}
