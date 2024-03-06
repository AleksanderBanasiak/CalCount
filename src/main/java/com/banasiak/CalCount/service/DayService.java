package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.Day;

import java.security.Principal;
import java.time.LocalDate;


public interface DayService {

    void createDayIfNotExist(LocalDate localDate, String userName);

    Day findDayByDate(LocalDate date, Long id);

    Day today(String userName);

    Day findDayById(Long id);

    void saveDay(Day day);


    Day changeDay(int howMuch, Day day, String name);

    boolean isToday(Day day, String userName);


    String dateFormat(LocalDate localDate);


}
