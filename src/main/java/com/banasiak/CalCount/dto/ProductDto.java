package com.banasiak.CalCount.dto;

import com.banasiak.CalCount.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto{

    private Long productId;
    private String name;
    private String kcal;
    private String protein;
    private String carbs;
    private String fiber;
    private String fat;
    private User user;

}
