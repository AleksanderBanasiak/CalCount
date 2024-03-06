package com.banasiak.CalCount.dto;

import com.banasiak.CalCount.model.MealType;

import java.util.List;

public record MealOfTheDayDto(Long id, List<ProductForTotal> totalProducts, ProductForTotal totalMeal, MealType mealType) {
}
