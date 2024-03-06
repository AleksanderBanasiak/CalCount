package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DayRepo extends JpaRepository<Day, Long> {


    @Query("SELECT d FROM Day d WHERE d.date =?1 and d.user.userId =?2")
    Day findDayByDateAndUserId(LocalDate localDate, Long id);




}
