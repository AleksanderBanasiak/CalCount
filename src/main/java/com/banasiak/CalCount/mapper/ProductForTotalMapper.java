package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.ProductForTotal;
import com.banasiak.CalCount.model.Total;

public class ProductForTotalMapper {

    public static Total mapProductForTotalToTotal(ProductForTotal product){
        return new Total(
                product.kcal(),
                product.protein(),
                product.carbs(),
                product.fiber(),
                product.fat()
        );
    }

}
