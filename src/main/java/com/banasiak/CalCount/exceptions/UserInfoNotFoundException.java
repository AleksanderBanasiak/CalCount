package com.banasiak.CalCount.exceptions;

public class UserInfoNotFoundException extends RuntimeException {

    public UserInfoNotFoundException(Long id) {
        super("Could not user info: "+id);
    }
}
