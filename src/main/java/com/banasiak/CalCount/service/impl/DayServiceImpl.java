package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.exceptions.DayNotFoundException;
import com.banasiak.CalCount.model.Day;
import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.repo.DayRepo;
import com.banasiak.CalCount.service.DayService;
import com.banasiak.CalCount.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService {


    private final DayRepo dayRepo;
    private final UserService userService;


    @Override
    public void createDayIfNotExist(LocalDate localDate, String userName) {
        if(findDayByDate(localDate, userService.findUserByName(userName).getUserId()) == null){
            Day day = new Day();
            day.setDate(localDate);
            day.setUser(userService.findUserByName(userName));
            dayRepo.save(day);
        }
    }

    @Override
    public Day findDayByDate(LocalDate date, Long id) {
        return dayRepo.findDayByDateAndUserId(date, id);
    }

    @Override
    public Day today(String userName) {
        Day day= findDayByDate(LocalDate.now(), userService.findUserByName(userName).getUserId());
        if(day==null){
            Day day1 = new Day();
            day1.setDate(LocalDate.now());
            User userByName = userService.findUserByName(userName);
            day1.setUser(userByName);
            saveDay(day1);
            return day1;
        }
        else {
            return day;
        }
    }
    @Override
    public Day findDayById(Long id) {
        return dayRepo.findById(id).orElseThrow(() ->new DayNotFoundException(id));
    }
    @Override
    public void saveDay(Day day) {
        dayRepo.save(day);
    }

    @Override
    public Day changeDay(int howMuch, Day day, String name) {
        LocalDate previousDate = day.getDate().plusDays(howMuch);
        createDayIfNotExist(previousDate, name);
      return findDayByDate(previousDate, userService.findUserByName(name).getUserId());
    }
    @Override
    public boolean isToday(Day day, String userName) {
        return day.getDate().equals(today(userName).getDate());
    }

    @Override
    public String dateFormat(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH));
    }


}
