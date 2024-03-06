package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.user.UserInfo;
import com.banasiak.CalCount.model.user.UserMacro;

public interface UserInfoService {


    boolean checkUserInfoValidation(UserInfo userInfo);

    UserInfo findUserInfoById(Long id);


    void saveUserInfo(UserInfo userInfo);

    void saveUserMacro(UserInfo userInfo, UserMacro userMacro);


    Long findLastId();


    void deleteUserInfo(UserInfo userInfo);

    void deleteUserInfoById(Long id);


    UserMacro getUserMacro(UserInfo userInfo);



}
