package com.banasiak.CalCount.mapper;

import com.banasiak.CalCount.dto.UserRequest;
import com.banasiak.CalCount.model.user.User;

public class UserRequestMapper {

    public static User mapUserRequestMapperToUser(UserRequest userRequest){
//        if(userRequest==null){
//            throw new NullPointerException("User request is null");
//        }
        return new User(
                userRequest.getUsername(),
                userRequest.getPassword(),
                userRequest.getRoles()
        );
    }
}
