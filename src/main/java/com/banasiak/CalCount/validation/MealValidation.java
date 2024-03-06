package com.banasiak.CalCount.validation;

import com.banasiak.CalCount.model.Meal;

public class MealValidation {



    public static boolean checkIsMealValid(Meal meal){
        final String REGEX_STRING = "^[a-zA-Z0-9\\s]+$";
        return meal.getMealName().matches(REGEX_STRING);
    }

}
