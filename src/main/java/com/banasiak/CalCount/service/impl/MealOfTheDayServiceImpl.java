package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.model.Day;
import com.banasiak.CalCount.model.MealOfTheDay;
import com.banasiak.CalCount.repo.MealOfTheDayRepo;
import com.banasiak.CalCount.service.MealOfTheDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealOfTheDayServiceImpl implements MealOfTheDayService {

    private final MealOfTheDayRepo mealRepo;

    @Autowired
    public MealOfTheDayServiceImpl(MealOfTheDayRepo mealRepo) {
        this.mealRepo = mealRepo;
    }
    @Override
    public void saveMealOfTheDay(MealOfTheDay meal) {
        mealRepo.save(meal);
    }
    @Override
    public List<MealOfTheDay> getAllMealsByDay(Day day) {
        return mealRepo.getMealOfTheDayByDay(day);
    }
}
