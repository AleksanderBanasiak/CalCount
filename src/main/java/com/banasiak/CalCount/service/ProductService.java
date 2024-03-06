package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(Long id);

    void saveProduct(Product product);


}
