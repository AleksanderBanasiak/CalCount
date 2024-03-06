package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.Day;
import com.banasiak.CalCount.model.MealOfTheDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealOfTheDayRepo extends JpaRepository<MealOfTheDay, Long> {


    List<MealOfTheDay> getMealOfTheDayByDay(Day day);


}
