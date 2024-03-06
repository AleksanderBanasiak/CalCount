package com.banasiak.CalCount.model;

import com.banasiak.CalCount.model.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    private String mealName;

    private MealType mealType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "meal_product",
            joinColumns = {
                    @JoinColumn(name = "meal_id", referencedColumnName =  "mealId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "productId")
            }
    )
    @JsonManagedReference
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
