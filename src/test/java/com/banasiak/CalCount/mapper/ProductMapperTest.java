package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.ProductDto;
import com.banasiak.CalCount.model.Product;
import com.banasiak.CalCount.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.banasiak.CalCount.mapper.ProductMapper.mapProductDtoToProduct;
import static com.banasiak.CalCount.mapper.ProductMapper.sortedProductsById;
import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private ProductMapper productMapper;


    @BeforeEach
    void setUp(){
        productMapper = new ProductMapper();
    }


    @Test
    public void shouldMapProductDtoToProduct() {
        //gievn
        ProductDto dto = new ProductDto(1L, "first", "4", "2", "1", "7", "40", new User());
        //when
        Product product = mapProductDtoToProduct(dto);
        //then
        assertEquals(dto.getName(), product.getName());
        assertEquals(Double.parseDouble(dto.getKcal()), product.getKcal());
        assertEquals(Double.parseDouble(dto.getProtein()), product.getProtein());
        assertEquals(Double.parseDouble(dto.getCarbs()), product.getCarbs());
        assertEquals(Double.parseDouble(dto.getFiber()), product.getFiber());
        assertEquals(Double.parseDouble(dto.getFat()), product.getFat());
        assertNotNull(dto.getUser());
    }
    @Test
    public void shouldThrowNullPointerExceptionWhenProductDtoIsNull(){
       var exception = assertThrows(NullPointerException.class, () ->mapProductDtoToProduct(null));
       assertEquals("The ProductDto is null", exception.getMessage());
    }



    @Test
    public void shouldSortedProductsById(){
        //given
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId(9L);
        Product product2 = new Product();
        product2.setProductId(3L);
        Product product3 = new Product();
        product3.setProductId(2L);
        Product product4 = new Product();
        product4.setProductId(1L);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        //when
        List<Product> sorted =sortedProductsById(products);
        //then
        assertEquals(sorted.get(0).getProductId(), 1L);
        assertEquals(sorted.get(1).getProductId(), 2L);
        assertEquals(sorted.get(2).getProductId(), 3L);
        assertEquals(sorted.get(3).getProductId(), 9L);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenProductListIsEmpty(){
        var exception = assertThrows(NullPointerException.class, () -> sortedProductsById(new ArrayList<>()));
        assertEquals("The product list is empty", exception.getMessage());
    }


}