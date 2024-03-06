package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.MealTypeDto;
import com.banasiak.CalCount.dto.MealsNameDto;
import com.banasiak.CalCount.model.Meal;

import java.util.List;

public class MealDtoMapper {

    public static List<MealsNameDto> mapMealToMealNameDto(List<Meal> meals){
        return meals.stream()
                .map(meal -> new MealsNameDto(meal.getMealId(), meal.getMealName()))
                .toList();
    }

    public static MealTypeDto mapMealToMealTypeDto(Meal meal){
        return new MealTypeDto(meal.getMealId(), meal.getMealType());
    }

}
