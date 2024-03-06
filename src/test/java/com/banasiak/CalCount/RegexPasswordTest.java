package com.banasiak.CalCount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexPasswordTest {



    @Test
    public void checkPassValidation(){
        //given
        final String PASSWORD_PATTERN =
                "^[a-zA-z0-9]{8,15}$";
        String password1 = "test1234";
        String password2 = "Test1234";
        String password3 = "TestTest";
        String password4 = "testtest";
        String password5 = "123456789";
        //when
        boolean matches1 = password1.matches(PASSWORD_PATTERN);
        boolean matches2 = password2.matches(PASSWORD_PATTERN);
        boolean matches3 = password3.matches(PASSWORD_PATTERN);
        boolean matches4 = password4.matches(PASSWORD_PATTERN);
        boolean matches5 = password5.matches(PASSWORD_PATTERN);
        //then
        Assertions.assertTrue(matches1);
        Assertions.assertTrue(matches2);
        Assertions.assertTrue(matches3);
        Assertions.assertTrue(matches4);
        Assertions.assertTrue(matches5);
    }

    @Test
    public void checkPassValidation2(){
        //given
        final String PASSWORD_PATTERN =
                "^[a-zA-z0-9]{8,15}$";

        String password1 = "test12345675675677567";
        String password2 = "";
        String password3 = " ";
        String password4 = "testt!!!asd2";
        String password5 = "!";
        //when
        boolean matches1 = password1.matches(PASSWORD_PATTERN);
        boolean matches2 = password2.matches(PASSWORD_PATTERN);
        boolean matches3 = password3.matches(PASSWORD_PATTERN);
        boolean matches4 = password4.matches(PASSWORD_PATTERN);
        boolean matches5 = password5.matches(PASSWORD_PATTERN);
        //then
        Assertions.assertFalse(matches1);
        Assertions.assertFalse(matches2);
        Assertions.assertFalse(matches3);
        Assertions.assertFalse(matches4);
        Assertions.assertFalse(matches5);
    }


}
