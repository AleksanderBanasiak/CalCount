package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.UserInfoDto;
import com.banasiak.CalCount.dto.UserInfoShowDto;
import com.banasiak.CalCount.model.user.Activity;
import com.banasiak.CalCount.model.user.Sex;
import com.banasiak.CalCount.model.user.UserInfo;

public class UserInfoShowMapper {

    public static UserInfoShowDto mapUserInfoDtoToUserInfoShowDto(UserInfoDto userInfoDto){

        return new UserInfoShowDto(
                changeSexEnumToString(userInfoDto.getSex()),
                userInfoDto.getWeight(),
                userInfoDto.getHeight(),
                userInfoDto.getAge(),
                changeActivityEnumToString(userInfoDto.getActivity())
        );
    }

    private static String changeSexEnumToString(Sex sex){
        return sex.name().charAt(0)+sex.name().substring(1).toLowerCase();
    }
    private static String changeActivityEnumToString(Activity activity){

        return activity.name().charAt(0) + activity.name().substring(1).toLowerCase().replace("_", " ");
    }

}
