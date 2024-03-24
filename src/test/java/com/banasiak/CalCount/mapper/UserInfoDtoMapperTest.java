package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.UserInfoDto;
import com.banasiak.CalCount.model.user.Sex;
import com.banasiak.CalCount.model.user.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.banasiak.CalCount.mapper.MealDtoMapper.mapMealToMealNameDto;
import static com.banasiak.CalCount.mapper.UserInfoDtoMapper.mapUserInfoDtoToUserInfo;
import static com.banasiak.CalCount.mapper.UserInfoDtoMapper.mapUserInfoToUserInfoDto;
import static org.junit.jupiter.api.Assertions.*;

class UserInfoDtoMapperTest {

    private UserInfoDtoMapper userInfoDtoMapper;


    @BeforeEach
    void setUp() {
        userInfoDtoMapper = new UserInfoDtoMapper();
    }

    @Test
    public void shouldMapUserInfoDtoToUserInfo() {
        //given
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserInfoId(1L);
        userInfoDto.setSex(Sex.MAN);
        userInfoDto.setHeight("177");
        userInfoDto.setWeight("77");
        userInfoDto.setAge("21");
        //when
        UserInfo userInfo = mapUserInfoDtoToUserInfo(userInfoDto);
        //then
        assertEquals(userInfo.getUserInfoId(), userInfoDto.getUserInfoId());
        assertEquals(userInfo.getSex(), userInfoDto.getSex());
        assertEquals(userInfo.getHeight(), Integer.parseInt(userInfoDto.getHeight()));
        assertEquals(userInfo.getWeight(), Integer.parseInt(userInfoDto.getWeight()));
        assertEquals(userInfo.getAge(), Integer.parseInt(userInfoDto.getAge()));
    }

    @Test
    public void shouldThrowNullPointerExceptionIfUserInfoDtoIsNull() {
        var exception = assertThrows(NullPointerException.class,
                () -> mapUserInfoDtoToUserInfo(null));
        assertEquals( "The UserInfoDto is null", exception.getMessage());
    }


    @Test
    public void shouldMapUserInfoToUserInfoDto() {
        //given
        UserInfo userInfo = new UserInfo();
        userInfo.setUserInfoId(1L);
        userInfo.setSex(Sex.MAN);
        userInfo.setWeight(78);
        userInfo.setHeight(177);
        userInfo.setAge(21);
        //when
        UserInfoDto userInfoDto = mapUserInfoToUserInfoDto(userInfo);
        //then
        assertEquals(userInfoDto.getUserInfoId(), userInfo.getUserInfoId());
        assertEquals(userInfoDto.getSex(), userInfo.getSex());
        assertEquals(userInfoDto.getWeight(), String.valueOf(userInfo.getWeight()));
        assertEquals(userInfoDto.getHeight(), String.valueOf(userInfo.getHeight()));
        assertEquals(userInfoDto.getAge(), String.valueOf(userInfo.getAge()));
    }

    @Test
    public void shouldThrowNullPointerExceptionIfUserInfoIsNull() {
        var exception = assertThrows(NullPointerException.class,
                () -> mapUserInfoToUserInfoDto(null));
        assertEquals( "The UserInfo is null", exception.getMessage());
    }

}