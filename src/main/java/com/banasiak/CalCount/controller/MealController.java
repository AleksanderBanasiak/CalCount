package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.service.MealService;
import com.banasiak.CalCount.service.ProductService;
import com.banasiak.CalCount.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

import static com.banasiak.CalCount.mapper.ProductDtoMapper.mapProductToProductNameDto;
import static com.banasiak.CalCount.validation.MealValidation.checkIsMealValid;

@Controller
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    private final UserService userService;

    private final ProductService productService;


    @GetMapping("/meals/create")
    public String createMeal(Model model, Principal principal){
        model.addAttribute("meal", new Meal());
        model.addAttribute("products", mapProductToProductNameDto(productService.getAllProducts(userService.findUserByName(principal.getName()).getUserId())));
        return "meal_add";
    }
    @PostMapping("/meals/save")
    public String saveMeal(@ModelAttribute Meal meal, Principal principal, Model model){
        if (!checkIsMealValid(meal)) {
            model.addAttribute("meal", new Meal());
            model.addAttribute("flag", true);
            model.addAttribute("products", mapProductToProductNameDto(productService.getAllProducts(userService.findUserByName(principal.getName()).getUserId())));
            return "meal_add";
        }
        if(meal.getProducts().isEmpty()){
            model.addAttribute("meal", new Meal());
            model.addAttribute("flag2", true);
            model.addAttribute("products", mapProductToProductNameDto(productService.getAllProducts(userService.findUserByName(principal.getName()).getUserId())));
            return "meal_add";
        }
        meal.setUser(userService.findUserByName(principal.getName()));
        mealService.saveMeal(meal);
        return "redirect:/main";
    }

}
