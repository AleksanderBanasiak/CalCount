package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.Grams;
import com.banasiak.CalCount.model.Meal;

import java.util.List;

public interface GramsService {


    void saveGrams(Grams grams);


    void saveListOfGrams(List<Grams> gramsList);


    List<Grams> fillGramsList(List<Double> userGrams, Meal meal);

}
