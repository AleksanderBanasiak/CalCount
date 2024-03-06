package com.banasiak.CalCount.dto;

import com.banasiak.CalCount.model.user.Activity;
import com.banasiak.CalCount.model.user.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto{

    private Long userInfoId;
    private Sex sex;
    private String weight;
    private String height;
    private String age;
    private Activity activity;

}
