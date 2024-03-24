package com.banasiak.CalCount.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class RegexProductTest {



    @ParameterizedTest(name = "Given weight {0} in grams should be True")
    @CsvSource({
          "21",
          "32",
          "2.3",
          "123",
          "0.4"
    })
    public void shouldMatch(String digit) {
        //given
        final String PASSWORD_PATTERN = "^\\d+(\\.\\d+)?$";
        //when
        boolean matches = digit.matches(PASSWORD_PATTERN);
        //then
        Assertions.assertTrue(matches);
    }
    @ParameterizedTest(name = "Given weight {0} in grams should be False")
    @CsvSource({
          "asd",
          "--g",
          "0.0.1",
          "!@",
          "vv"
    })
    public void shouldDontMatch(String digit) {
        //given
        final String PASSWORD_PATTERN = "^\\d+(\\.\\d+)?$";
        //when
        boolean matches = digit.matches(PASSWORD_PATTERN);
        //then
        Assertions.assertFalse(matches);
    }





}
