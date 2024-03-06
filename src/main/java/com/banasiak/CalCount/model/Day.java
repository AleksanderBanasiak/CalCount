package com.banasiak.CalCount.model;

import com.banasiak.CalCount.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayId;

    private LocalDate date;


    @OneToMany
    private Set<MealOfTheDay> mealOfTheDay;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
