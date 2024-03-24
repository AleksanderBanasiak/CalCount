package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.model.Meal;
import com.banasiak.CalCount.model.MealType;
import com.banasiak.CalCount.service.MealService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class MealOfTheDayControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void shouldGetSingleMealOfTheDay() throws Exception {
        //given
        MvcResult mvcResult = mockMvc.perform(get("/meals/1"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        Meal meal = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Meal.class);

        assertThat(meal).isNotNull();
        assertThat(meal.getMealId()).isEqualTo(1L);
        assertThat(meal.getMealType()).isEqualTo(MealType.LUNCH);
    }



    @Test
    public void shouldGetMealType(){
        //given
        MealService mealService = mock(MealService.class);
        when(mealService.getMealById(1L).getMealType()).thenReturn(MealType.BRUNCH);
        //when
        MealType type = mealService.getMealById(1L).getMealType();
        //then
        Assertions.assertEquals(type, MealType.BRUNCH);

    }










}