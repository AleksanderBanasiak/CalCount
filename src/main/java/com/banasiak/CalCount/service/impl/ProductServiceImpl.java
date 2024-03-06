package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.model.Product;
import com.banasiak.CalCount.repo.ProductRepo;
import com.banasiak.CalCount.service.ProductService;
import com.banasiak.CalCount.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts(Long id) {

        return productRepo.findAllForUser(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

}
