package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.ProductDto;
import com.banasiak.CalCount.model.Product;

import java.util.Comparator;
import java.util.List;

public class ProductMapper {

    public static List<Product> sortedProductsById(List<Product> products){
      return products.stream()
              .sorted(Comparator.comparingLong(Product::getProductId))
              .toList();
    }

    public static Product mapProductDtoToProduct(ProductDto productDto){
        return new Product(productDto.getName(), Double.parseDouble(productDto.getKcal()),
                Double.parseDouble(productDto.getProtein()), Double.parseDouble(productDto.getCarbs())
        ,Double.parseDouble(productDto.getFiber()), Double.parseDouble(productDto.getFat()),
                productDto.getUser()
        );
    }

}
