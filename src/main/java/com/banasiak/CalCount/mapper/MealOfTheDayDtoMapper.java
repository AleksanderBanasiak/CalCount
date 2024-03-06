package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.MealOfTheDayDto;
import com.banasiak.CalCount.model.MealOfTheDay;

import java.util.List;

import static com.banasiak.CalCount.calculation.ProductCalculation.calcMacro;
import static com.banasiak.CalCount.calculation.ProductCalculation.calcMacroForMeal;

public class MealOfTheDayDtoMapper {

    public static List<MealOfTheDayDto> mapMealOfTheDayToDto(List<MealOfTheDay> meals){
        return meals.stream()
                .map(meal -> new MealOfTheDayDto(
                        meal.getMealOfTheDayId(),
                        calcMacro(meal.getGrams()),
                        calcMacroForMeal(calcMacro(meal.getGrams()),
                                meal.getMeal().getMealName()),
                        meal.getMeal().getMealType()
                )).toList();
    }

}
