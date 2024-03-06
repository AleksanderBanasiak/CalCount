package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.model.GivenGrams;
import com.banasiak.CalCount.model.MealOfTheDay;
import com.banasiak.CalCount.model.MealType;
import com.banasiak.CalCount.model.Product;
import com.banasiak.CalCount.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.MealDtoMapper.mapMealToMealNameDto;
import static com.banasiak.CalCount.mapper.MealDtoMapper.mapMealToMealTypeDto;
import static com.banasiak.CalCount.mapper.ProductDtoMapper.mapProductToProductNameDto;
import static com.banasiak.CalCount.mapper.ProductMapper.sortedProductsById;

@Controller
@RequiredArgsConstructor
public class MealOfTheDayController {
    private final MealService mealService;
    private final DayService dayService;
    private final MealOfTheDayService mealOfTheDayService;
    private final GramsService gramsService;
    private final UserService userService;

    @GetMapping("/meals/add/{type}")
    public String addMealInDay(@PathVariable MealType type, Model model, Principal principal){
        model.addAttribute("meals", mapMealToMealNameDto(mealService.getMealsByType(type, userService.findUserByName(principal.getName()).getUserId())));
        model.addAttribute("type", type);
        model.addAttribute("name", type.name().charAt(0)+type.name().substring(1).toLowerCase());
        return "addMealOfDay";
    }
    @GetMapping("/meals/{id}")
    public String chooseMeal(@PathVariable Long id, Model model, Principal principal){
        model.addAttribute("grams", new GivenGrams());
        List<Product> products = new ArrayList<>(mealService.getMealById(id).getProducts());
        model.addAttribute("product", mapProductToProductNameDto(sortedProductsById(products)));
        model.addAttribute("mealId", id);
        MealType type = mealService.getMealById(id).getMealType();
        model.addAttribute("meals", mapMealToMealNameDto(mealService.getMealsByType(type, userService.findUserByName(principal.getName()).getUserId())));
        model.addAttribute("type", type);
        model.addAttribute("name", type.name().charAt(0)+type.name().substring(1).toLowerCase());
        model.addAttribute("mealName", mealService.getMealById(id).getMealName());

        return "addProductOfSelectedMeal";
    }
    @PostMapping("/meals/save/grams/{id}")
    public String saveChosenProducts(@PathVariable Long id, @ModelAttribute GivenGrams givenGrams, Principal principal){
        mealOfTheDayService.saveMealOfTheDay(new MealOfTheDay(gramsService.fillGramsList(givenGrams.getGrams(),mealService.getMealById(id)),mealService.getMealById(id), dayService.today(principal.getName())));
        return "redirect:/main";
    }


}
