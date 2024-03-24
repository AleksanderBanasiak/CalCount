package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.UserInfoDto;
import com.banasiak.CalCount.dto.UserInfoShowDto;
import com.banasiak.CalCount.model.user.Activity;
import com.banasiak.CalCount.model.user.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.banasiak.CalCount.mapper.UserInfoShowMapper.mapUserInfoDtoToUserInfoShowDto;
import static com.banasiak.CalCount.mapper.UserRequestMapper.mapUserRequestMapperToUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInfoShowMapperTest {
    
    
    private UserInfoShowMapper userInfoShowMapper;


    @BeforeEach
    void setUp() {
        userInfoShowMapper = new UserInfoShowMapper();
    }

    @Test
    public void shouldMapUserInfoDtoToUserInfoShowDto() {
        //given
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserInfoId(1L);
        userInfoDto.setSex(Sex.MAN);
        userInfoDto.setHeight("177");
        userInfoDto.setWeight("77");
        userInfoDto.setAge("21");
        userInfoDto.setActivity(Activity.LOW);
        //when
        UserInfoShowDto userInfoShowDto = mapUserInfoDtoToUserInfoShowDto(userInfoDto);
        //then
        assertEquals(userInfoShowDto.getHeight(), userInfoDto.getHeight());
        assertEquals(userInfoShowDto.getWeight(), userInfoDto.getWeight());
        assertEquals(userInfoShowDto.getAge(), userInfoDto.getAge());
    }


    @Test
    public void shouldThrowNullPointerExceptionIfUserInfoDtoIsNull() {
        var exception = assertThrows(NullPointerException.class,
                () -> mapUserInfoDtoToUserInfoShowDto(null));
        assertEquals( "User Info Dto is null", exception.getMessage());
    }
    
}