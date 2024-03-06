package com.banasiak.CalCount.calculation;

import com.banasiak.CalCount.dto.MealOfTheDayDto;
import com.banasiak.CalCount.dto.ProductForTotal;
import com.banasiak.CalCount.model.Grams;
import com.banasiak.CalCount.model.Product;
import com.banasiak.CalCount.model.Total;

import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.ProductForTotalMapper.mapProductForTotalToTotal;

public class ProductCalculation {

    public static Total total(List<MealOfTheDayDto> meals){
        List<ProductForTotal> products = new ArrayList<>();
        for (MealOfTheDayDto mealOfTheDayDto : meals) {
            products.addAll(mealOfTheDayDto.totalProducts());
        }
        return mapProductForTotalToTotal(calcMacroForMeal(products, "total"));
    }

    public static ProductForTotal calcMacroForMeal(List<ProductForTotal> products, String mealName){
        return new ProductForTotal(mealName,
                products.stream().mapToDouble(ProductForTotal::kcal).sum(),
                products.stream().mapToDouble(ProductForTotal::protein).sum(),
                products.stream().mapToDouble(ProductForTotal::carbs).sum(),
                products.stream().mapToDouble(ProductForTotal::fiber).sum(),
                products.stream().mapToDouble(ProductForTotal::fat).sum());
    }
    public static List<ProductForTotal> calcMacro(List<Grams> grams){
        List<ProductForTotal> productForTotals = new ArrayList<>();
        for (Grams gram : grams) {
            productForTotals.add(calcMacroForSingleProduct(gram.getGivenGrams(), gram.getProduct()));
        }
        return productForTotals;
    }
    private static ProductForTotal calcMacroForSingleProduct(double grams, Product product){
        return new ProductForTotal(
                product.getName(),
                calculate(product.getKcal(), grams),
                calculate(product.getProtein(), grams),
                calculate(product.getCarbs(), grams),
                calculate(product.getFiber(), grams),
                calculate(product.getFat(), grams)
        );
    }
    public static double calculate(double macro, double grams){
        long round = Math.round((macro * grams) / 100);
        if(macro <0 || grams <0){
            throw new IllegalArgumentException();
        }else {
            return round;
        }

    }

}
