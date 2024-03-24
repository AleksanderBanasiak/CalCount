package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.MealOfTheDayDto;
import com.banasiak.CalCount.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.MealDtoMapper.mapMealToMealNameDto;
import static com.banasiak.CalCount.mapper.MealOfTheDayDtoMapper.mapMealOfTheDayToDto;
import static org.junit.jupiter.api.Assertions.*;

class MealOfTheDayDtoMapperTest {

    private MealOfTheDayDtoMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new MealOfTheDayDtoMapper();
    }


    @Test
    public void shouldMapMealOfTheDayToDto() {
        //given
        List<MealOfTheDay> meals = new ArrayList<>();
        MealOfTheDay mealOfTheDay = new MealOfTheDay();
        mealOfTheDay.setMealOfTheDayId(2137L);
        Grams grams1 = new Grams(1L, 213, new Product());
        Grams grams2 = new Grams(2L, 212, new Product());
        mealOfTheDay.setGrams(List.of(grams1, grams2));
        Meal meal = new Meal();
        meal.setMealName("meal");
        meal.setMealType(MealType.LUNCH);
        mealOfTheDay.setMeal(meal);
        meals.add(mealOfTheDay);
        //when
        List<MealOfTheDayDto> mealOfTheDayDtos = mapMealOfTheDayToDto(meals);
        //then
        assertEquals(mealOfTheDayDtos.get(0).mealType(), meal.getMealType());
    }


    @Test
    public void shouldThrowNullPointerExceptionIfMealOfTheDayListIsEmpty() {
        var exception = assertThrows(NullPointerException.class,
                () -> mapMealOfTheDayToDto(new ArrayList<>()));
        assertEquals( "The meal list is empty", exception.getMessage());
    }





}