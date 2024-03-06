package com.banasiak.CalCount.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mealOfTheDay")
public class MealOfTheDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealOfTheDayId;

    @OneToMany
    @JoinColumn(name = "mealOfTheDayId")
    private List<Grams> grams;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;


    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    public MealOfTheDay(List<Grams> grams, Meal meal, Day day) {
        this.grams = grams;
        this.meal = meal;
        this.day = day;
    }
}
