package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.exceptions.MealNotFoundException;
import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.MealType;
import com.banasiak.CalCount.repo.MealRepo;
import com.banasiak.CalCount.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepo mealRepo;

    @Autowired
    public MealServiceImpl(MealRepo mealRepo) {
        this.mealRepo = mealRepo;
    }

    @Override
    public void saveMeal(Meal meal) {
        mealRepo.save(meal);
    }

    @Override
    public List<Meal> getMealsByType(MealType type, Long id) {
        return mealRepo.getMealByMealTypeAndUser(type, id);
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepo.findById(id).orElseThrow(() -> new MealNotFoundException(id));
    }




}
