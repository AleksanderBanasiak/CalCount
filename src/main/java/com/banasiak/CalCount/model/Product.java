package com.banasiak.CalCount.model;

import com.banasiak.CalCount.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private double kcal;
    private double protein;
    private double carbs;
    private double fiber;
    private double fat;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Meal> meals;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Product(double kcal, double protein, double carbs, double fiber, double fat) {
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fiber = fiber;
        this.fat = fat;
    }

    public Product(String name, double kcal, double protein, double carbs, double fiber, double fat, User user) {
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fiber = fiber;
        this.fat = fat;
        this.user = user;
    }
}
