package com.banasiak.CalCount.calculation;

import com.banasiak.CalCount.model.user.Activity;
import com.banasiak.CalCount.model.user.Sex;
import com.banasiak.CalCount.model.user.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.banasiak.CalCount.calculation.UserCaloricDemand.*;
import static com.banasiak.CalCount.mapper.MealOfTheDayDtoMapper.mapMealOfTheDayToDto;
import static org.junit.jupiter.api.Assertions.*;

class UserCaloricDemandTest {


    private UserCaloricDemand userCaloricDemand;


    @BeforeEach
    void setUp() {
        userCaloricDemand = new UserCaloricDemand();
    }


    @Test
    public void shouldCalculateCaloricDemand() {
        //given
        UserInfo userInfo = prepartUserInfo();

        //when
        int calculatedCaloricDemand = calculateCaloricDemand(userInfo);
        //then
        assertEquals(calculatedCaloricDemand, 2598);
    }

    @Test
    public void shouldCalculateFiber() {
        //given
        UserInfo userInfo = prepartUserInfo();
        //when
        int calculateFiber = calculateFiber(userInfo);
        //then
        assertEquals(calculateFiber, 30);
    }

    @Test
    public void shouldCalculateProtein() {
        //given
        UserInfo userInfo = prepartUserInfo();

        //when
        int calculateProtein = calculateProtein(userInfo);
        //then
        assertEquals(calculateProtein, 187);
    }

     @Test
    public void shouldCalculateFat() {
        //given
        UserInfo userInfo = prepartUserInfo();

        //when
        int calculateFat = calculateFat(userInfo);
        //then
        assertEquals(calculateFat, 112);
    }
    @Test
    public void shouldThrowNullPointerExceptionIfOneOfParamsIsNull() {
        //given
        UserInfo userInfo = new UserInfo();
        userInfo.setSex(Sex.MAN);
        userInfo.setWeight(78);
        userInfo.setHeight(0);
        userInfo.setAge(19);
        userInfo.setActivity(Activity.LOW);
        //when
        var exception = assertThrows(NullPointerException.class,
                () -> calculateCaloricDemand(userInfo));

        //then
        assertEquals( "Data is not valid ,cant calculate", exception.getMessage());
    }

    private UserInfo prepartUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setSex(Sex.MAN);
        userInfo.setWeight(78);
        userInfo.setHeight(180);
        userInfo.setAge(19);
        userInfo.setActivity(Activity.LOW);
        return userInfo;
    }



}