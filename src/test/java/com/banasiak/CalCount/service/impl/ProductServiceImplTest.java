package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.model.Product;
import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.repo.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepo productRepo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void shouldSuccessfullySaveProduct() {
        //given
        Product product = new Product(2,21,37,2,1);
        //when
        Mockito.when(productRepo.save(product)).thenReturn(product);

        Product save = productService.saveProduct(product);
        //then
        assertEquals(product.getKcal(), save.getKcal());
        assertEquals(product.getProtein(), save.getProtein());
        assertEquals(product.getCarbs(), save.getCarbs());
        assertEquals(product.getFiber(), save.getFiber());
        assertEquals(product.getFat(), save.getFat());

        verify(productRepo, times(1)).save(product);
    }


    @Test
    public void shouldGetAllProducts() {
        //given
        Long id =1L;
        List<Product> productList = new ArrayList<>();
        User user = new User();
        user.setUserId(1L);
        productList.add(new Product("product", 21,32,12,32,12, user));

        //when
        Mockito.when(productRepo.findAllForUser(id)).thenReturn(productList);

        List<Product> allProductsForUser = productService.getAllProducts(id);
        //then
        assertEquals(productList.size(), allProductsForUser.size());

        verify(productRepo, times(1)).findAllForUser(id);
    }

    
    
    
    
    
}