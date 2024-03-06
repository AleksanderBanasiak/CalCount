package com.banasiak.CalCount.validation;

public class UserValidation {


    public static boolean checkNameValidation(String name){
        return name.matches("^[a-zA-z0-9]{3,10}$");
    }
    public static boolean checkPassValidation(String pass){
        return pass.matches("^[a-zA-z0-9]{5,15}$");
    }


}
