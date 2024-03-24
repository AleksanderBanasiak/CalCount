package com.banasiak.CalCount.calculation;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static com.banasiak.CalCount.calculation.ProductCalculation.calculate;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ProductCalculationTest {


    @ParameterizedTest(name = "Given macro {0} and grams {1} should return {2}")
    @CsvSource({
            "321, 100, 321",
            "200, 200, 400",
            "12, 12, 1",
            "44, 32, 14"
    })
    public void shouldReturnRoundedDigits(double macro, double grams, long result) {
        //given
        //when
        double calculate = calculate(macro, grams);
        //then
        assertEquals(calculate, result);
    }



    @ParameterizedTest(name = "Given macro {0} and grams {1} should return {2}")
    @CsvSource({
            "321, 2.2, 32",
            "200, 220, 7",
            "12, 12, 189",
            "4.4, 32, 84"
    })
    public void shouldNotReturnRoundedDigits(double macro, double grams, long result) {
        //given
        //when
        double calculate = calculate(macro, grams);
        //then
        assertNotEquals(calculate, result);
    }
    @ParameterizedTest(name = "Given macro {0} and grams {1} should throw IllegalArgumentException")
    @CsvSource({
            "-2.2, 2.2",
            "200, -4.1",
            "12, -10",
            "-19, 32"
    })
    public void shouldThrowIllegalArgumentException(double macro, double grams) {
        assertThrows(IllegalArgumentException.class, () -> calculate(macro, grams));
    }







}