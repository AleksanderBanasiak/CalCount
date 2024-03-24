package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.MealTypeDto;
import com.banasiak.CalCount.dto.MealsNameDto;
import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.MealType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.MealDtoMapper.mapMealToMealNameDto;
import static com.banasiak.CalCount.mapper.MealDtoMapper.mapMealToMealTypeDto;
import static com.banasiak.CalCount.mapper.ProductMapper.mapProductDtoToProduct;
import static org.junit.jupiter.api.Assertions.*;

class MealDtoMapperTest {


    private MealDtoMapper mealDtoMapper;


    @BeforeEach
    void setUp() {
        mealDtoMapper = new MealDtoMapper();
    }


    @Test
    public void shouldMapMealToMealTypeDto() {
        //given
        Meal meal = new Meal();
        meal.setMealId(1L);
        meal.setMealType(MealType.LUNCH);
        //when
        MealTypeDto mealTypeDto = mapMealToMealTypeDto(meal);
        //then
        assertEquals(mealTypeDto.id(), meal.getMealId());
        assertEquals(mealTypeDto.type(), meal.getMealType());
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenProductDtoIsNull(){
        var exception = assertThrows(NullPointerException.class, () ->mapMealToMealTypeDto(null));
        assertEquals("The Meal is null", exception.getMessage());
    }


    @Test
    public void shouldMapMealToMealNameDto() {
        //given
        Meal meal1 = new Meal();
        Meal meal2 = new Meal();
        meal1.setMealId(1L);
        meal2.setMealId(4L);
        meal1.setMealName("first");
        meal2.setMealName("second");
        List<Meal> meals = List.of(meal1, meal2);
        //when
        List<MealsNameDto> mealsNameDtos = mapMealToMealNameDto(meals);
        //then
        assertEquals(mealsNameDtos.get(0).mealId(), meal1.getMealId());
        assertEquals(mealsNameDtos.get(0).mealName(), meal1.getMealName());
        assertEquals(mealsNameDtos.get(1).mealId(), meal2.getMealId());
        assertEquals(mealsNameDtos.get(1).mealName(), meal2.getMealName());
    }


    @Test
    public void shouldThrowNullPointerExceptionWhenListIsNull() {
        var exception = assertThrows(NullPointerException.class,
                () -> mapMealToMealNameDto(new ArrayList<>()));
        assertEquals( "The meal list is empty", exception.getMessage());
    }












}