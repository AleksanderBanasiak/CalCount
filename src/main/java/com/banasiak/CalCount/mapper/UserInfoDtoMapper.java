package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.UserInfoDto;
import com.banasiak.CalCount.model.user.UserInfo;

public class UserInfoDtoMapper {

    public static UserInfo mapUserInfoDtoToUserInfo(UserInfoDto userInfoDto){
//        if(userInfoDto==null){
//            throw new NullPointerException("The UserInfoDto is null");
//        }

        return new UserInfo(
                userInfoDto.getUserInfoId(),
                userInfoDto.getSex(),
                Integer.parseInt(userInfoDto.getWeight()),
                Integer.parseInt(userInfoDto.getHeight()),
                Integer.parseInt( userInfoDto.getAge()),
                userInfoDto.getActivity(),
                null);
    }

    public static UserInfoDto mapUserInfoToUserInfoDto(UserInfo userInfo){
//        if(userInfo==null){
//            throw new NullPointerException("The UserInfo is null");
//        }
        return new UserInfoDto(
                userInfo.getUserInfoId(),
                userInfo.getSex(),
                String.valueOf(userInfo.getWeight()),
                String.valueOf(userInfo.getHeight()),
                String.valueOf(userInfo.getAge()),
                userInfo.getActivity()
        );
    }

}
