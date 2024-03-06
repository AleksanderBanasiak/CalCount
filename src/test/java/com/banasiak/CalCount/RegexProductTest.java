package com.banasiak.CalCount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexProductTest {






    @Test
    public void checkProductValidation(){
        //given
        final String PASSWORD_PATTERN =
                "^\\d+(\\.\\d+)?$";
        String password1 = "21";
        String password2 = "2.3";
        String password3 = "321";
        String password4 = "7";
        String password5 = "2";
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
}
