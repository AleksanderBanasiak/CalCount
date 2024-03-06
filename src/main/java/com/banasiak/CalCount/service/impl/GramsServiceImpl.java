package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.model.Grams;
import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.Product;
import com.banasiak.CalCount.repo.GramsRepo;
import com.banasiak.CalCount.service.GramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.ProductMapper.sortedProductsById;

@Service
public class GramsServiceImpl implements GramsService {


    private final GramsRepo gramsRepo;


    @Autowired
    public GramsServiceImpl(GramsRepo gramsRepo) {
        this.gramsRepo = gramsRepo;
    }


    @Override
    public void saveGrams(Grams grams) {
        gramsRepo.save(grams);
    }

    @Override
    public void saveListOfGrams(List<Grams> gramsList) {

        for (Grams grams : gramsList) {
            saveGrams(grams);
        }
    }

    public List<Grams> fillGramsList(List<Double> userGrams, Meal meal){
        List<Grams> gramsList = new ArrayList<>();
        List<Product> products = new ArrayList<>(meal.getProducts());
        List<Product> collect = sortedProductsById(products);
        for (int i = 0; i < userGrams.size(); i++) {
            Grams grams = new Grams();
            grams.setGivenGrams(userGrams.get(i));
            grams.setProduct(collect.get(i));
            saveGrams(grams);
            gramsList.add(grams);
        }
        return gramsList;
    }



}
