package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepo extends JpaRepository<Meal, Long> {



    List<Meal> getMealByMealType(MealType mealType);


    @Query("SELECT m FROM Meal m WHERE m.mealType =?1 and m.user.userId =?2")
    List<Meal> getMealByMealTypeAndUser(MealType mealType, Long id);
}
