package com.banasiak.CalCount.model;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;


@Getter
@Setter
public class Total {
    private String kcal;
    private String protein;
    private String carbs;
    private String fiber;
    private String fat;
    public Total(double kcal, double protein, double carbs, double fiber, double fat) {
        DecimalFormat format = new DecimalFormat("0.#");
        this.kcal = format.format(kcal);
        this.protein = format.format(protein);
        this.carbs = format.format(carbs);
        this.fiber = format.format(fiber);
        this.fat = format.format(fat);
    }
}
