package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.model.user.UserInfo;

import java.util.List;


public interface UserService {

    void saveUser(User user);

    void saveUsersInfo(User user, UserInfo userInfo);


    User findUserByName(String name);

    User findUserById(Long id);





}
