package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.ProductForTotal;
import com.banasiak.CalCount.model.Total;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.banasiak.CalCount.mapper.ProductDtoMapper.mapProductToProductNameDto;
import static com.banasiak.CalCount.mapper.ProductForTotalMapper.mapProductForTotalToTotal;
import static org.junit.jupiter.api.Assertions.*;

class ProductForTotalMapperTest {

    private ProductForTotalMapper productForTotalMapper;


    @BeforeEach
    void setUp() {
        productForTotalMapper = new ProductForTotalMapper();
    }

    @Test
    public void shouldMapProductForTotalToTotal() {
        //given
        DecimalFormat format = new DecimalFormat("0.#");
        ProductForTotal productForTotal = new ProductForTotal("product", 2,3,45,7,5);
        //when
        Total total = mapProductForTotalToTotal(productForTotal);
        //then
        assertEquals(total.getKcal(), format.format(productForTotal.kcal()));
        assertEquals(total.getProtein(), format.format(productForTotal.protein()));
        assertEquals(total.getCarbs(), format.format(productForTotal.carbs()));
        assertEquals(total.getFat(), format.format(productForTotal.fat()));
        assertEquals(total.getFiber(), format.format(productForTotal.fiber()));
    }


    @Test
    public void shouldThrowNullPointerExceptionIfProductListIsEmpty() {
        var exception = assertThrows(NullPointerException.class, () ->  mapProductForTotalToTotal(null));
        assertEquals("The product is null", exception.getMessage());
    }

}