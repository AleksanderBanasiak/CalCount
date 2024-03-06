package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.MealType;

import java.util.List;

public interface MealService {

    void saveMeal(Meal meal);


    List<Meal> getMealsByType(MealType type, Long id);

    Meal getMealById(Long id);




}
