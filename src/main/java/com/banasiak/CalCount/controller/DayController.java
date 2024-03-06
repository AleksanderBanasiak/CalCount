package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.dto.MealOfTheDayDto;
import com.banasiak.CalCount.model.Day;
import com.banasiak.CalCount.model.MealType;
import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.service.DayService;
import com.banasiak.CalCount.service.MealOfTheDayService;
import com.banasiak.CalCount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import static com.banasiak.CalCount.calculation.ProductCalculation.total;
import static com.banasiak.CalCount.mapper.MealOfTheDayDtoMapper.mapMealOfTheDayToDto;

@Controller
public class DayController {
    private final DayService dayService;
    private final UserService userService;
    private final MealOfTheDayService meal;
    private Day day;


    @GetMapping("/today")
    private String setDay(Principal principal){
        this.day = dayService.today(principal.getName());
        return "redirect:/main";
    }

    @Autowired
    public DayController(DayService dayService, UserService userService, MealOfTheDayService meal) {
        this.dayService = dayService;
        this.userService = userService;
        this.meal = meal;
    }
    @GetMapping("/main")
    public String displayMainSiteTest(Model model, Principal principal){
        User userByName = userService.findUserByName(principal.getName());
        List<MealOfTheDayDto> meals = mapMealOfTheDayToDto(meal.getAllMealsByDay(day));
        model.addAttribute("types", Arrays.asList(MealType.values()));
        model.addAttribute("day", dayService.dateFormat(day.getDate()));
        model.addAttribute("flag", dayService.isToday(day, principal.getName()));
        model.addAttribute("meals", meals);
        model.addAttribute("total", total(meals));
        model.addAttribute("userName", principal.getName());
        model.addAttribute("macro", userByName.getUserInfo().getUserMacro());
        return "index";
    }
    @GetMapping("/previousDay")
    public String previousDay(Principal principal){
        this.day = dayService.changeDay(-1, day, principal.getName());
        return "redirect:/main";
    }
    @GetMapping("/nextDay")
    public String nextDay(Principal principal) {
        this.day = dayService.changeDay(1, day, principal.getName());
        return "redirect:/main";
    }

}





