package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.MealType;
import com.banasiak.CalCount.repo.MealRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MealServiceImplTest {

    @InjectMocks
    private MealServiceImpl mealService;

    @Mock
    private MealRepo mealRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldSuccessfullySaveMeal() {
        //given
        Meal meal = new Meal("meal", MealType.LUNCH);
        //when
        Mockito.when(mealRepo.save(meal)).thenReturn(meal);

        Meal save = mealRepo.save(meal);
        //then
        assertEquals(save.getMealType(), meal.getMealType());
        assertEquals(save.getMealName(), meal.getMealName());

        verify(mealRepo, times(1)).save(meal);
    }


    @Test
    public void shouldGetAllMealsByType() {
        //given
        Meal meal1 = new Meal("meal1", MealType.LUNCH);
        Meal meal2 = new Meal("meal2", MealType.LUNCH);
        Meal meal3 = new Meal("meal3", MealType.BRUNCH);
        Meal meal4 = new Meal("meal4", MealType.BREAKFAST);

        List<Meal> meals = List.of(meal1, meal2, meal3, meal4);
        //when
        Mockito.when(mealRepo.getMealByMealTypeAndUser(MealType.LUNCH, 1L)).thenCallRealMethod().thenReturn(meals);
        //then

        List<Meal> mealByMealTypeAndUser = mealRepo.getMealByMealTypeAndUser(MealType.LUNCH, 1L);

        assertEquals(mealByMealTypeAndUser.size(), 1);
    }


}