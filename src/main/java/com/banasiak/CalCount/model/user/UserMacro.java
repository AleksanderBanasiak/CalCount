package com.banasiak.CalCount.model.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_macro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMacro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMacroId;

    private int kcal;
    private int protein;
    private int carbs;
    private int fiber;
    private int fat;

    public UserMacro(int kcal, int protein, int carbs, int fiber, int fat) {
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fiber = fiber;
        this.fat = fat;
    }
}
