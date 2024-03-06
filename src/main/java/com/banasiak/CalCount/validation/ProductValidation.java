package com.banasiak.CalCount.validation;

import com.banasiak.CalCount.dto.ProductDto;

public class ProductValidation {

     public static boolean checkIsProductValid(ProductDto productDto){

        final String REGEX_DIGIT = "^\\d+(\\.\\d+)?$";
        final String REGEX_STRING = "^[a-zA-Z0-9\\s]+$";

        return productDto.getProtein().matches(REGEX_DIGIT) && productDto.getCarbs().matches(REGEX_DIGIT)
                && productDto.getFat().matches(REGEX_DIGIT) && productDto.getFiber().matches(REGEX_DIGIT)
                && productDto.getKcal().matches(REGEX_DIGIT) && productDto.getName().matches(REGEX_STRING);
    }

}
