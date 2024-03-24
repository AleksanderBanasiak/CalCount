package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.ProductNameDto;
import com.banasiak.CalCount.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.ProductDtoMapper.mapProductToProductNameDto;
import static org.junit.jupiter.api.Assertions.*;

class ProductDtoMapperTest {

    private ProductDtoMapper productDtoMapper;


    @BeforeEach
    void setUp() {
        productDtoMapper = new ProductDtoMapper();
    }

    @Test
    public void shouldMapProductToProductNameDto() {
        //given
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setName("first");
        product1.setProductId(1L);
        product2.setName("second");
        product2.setProductId(2L);
        List<Product> productList = List.of(product1, product2);
        //when
        List<ProductNameDto> productNameDtos = mapProductToProductNameDto(productList);
        //then
        assertEquals(productNameDtos.get(0).productId(), product1.getProductId());
        assertEquals(productNameDtos.get(0).name(), product1.getName());
        assertEquals(productNameDtos.get(1).productId(), product2.getProductId());
        assertEquals(productNameDtos.get(1).name(), product2.getName());
    }

    @Test
    public void shouldThrowNullPointerExceptionIfProductListIsEmpty() {
        var exception = assertThrows(NullPointerException.class, () ->  mapProductToProductNameDto(new ArrayList<>()));
        assertEquals("The products list is empty", exception.getMessage());
    }





}