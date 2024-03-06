package com.banasiak.CalCount.dto;

import com.banasiak.CalCount.model.user.Activity;
import com.banasiak.CalCount.model.user.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoShowDto {

    private String sex;
    private String weight;
    private String height;
    private String age;
    private String activity;

}
