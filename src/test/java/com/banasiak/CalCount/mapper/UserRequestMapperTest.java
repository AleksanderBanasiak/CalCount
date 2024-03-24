package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.UserRequest;
import com.banasiak.CalCount.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.banasiak.CalCount.mapper.UserInfoDtoMapper.mapUserInfoToUserInfoDto;
import static com.banasiak.CalCount.mapper.UserRequestMapper.mapUserRequestMapperToUser;
import static org.junit.jupiter.api.Assertions.*;

class UserRequestMapperTest {

    private UserRequestMapper userRequestMapper;


    @BeforeEach
    void setUp() {
        userRequestMapper = new UserRequestMapper();
    }


    @Test
    public void shouldMapUserRequestMapperToUser() {
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("user");
        userRequest.setPassword("pass");
        //when
        User user = mapUserRequestMapperToUser(userRequest);
        //then
        assertEquals(user.getUsername(), userRequest.getUsername());
        assertEquals(user.getPassword(), userRequest.getPassword());
    }

    @Test
    public void shouldThrowNullPointerExceptionIfUserRequestIsNull() {
        var exception = assertThrows(NullPointerException.class,
                () -> mapUserRequestMapperToUser(null));
        assertEquals( "User request is null", exception.getMessage());
    }

}