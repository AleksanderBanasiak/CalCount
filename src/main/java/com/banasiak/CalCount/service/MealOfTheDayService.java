package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.Day;
import com.banasiak.CalCount.model.MealOfTheDay;

import java.util.List;

public interface MealOfTheDayService {

    void saveMealOfTheDay(MealOfTheDay meal);

    List<MealOfTheDay> getAllMealsByDay(Day day);


}
