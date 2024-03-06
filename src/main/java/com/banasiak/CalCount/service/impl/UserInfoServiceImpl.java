package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.exceptions.UserInfoNotFoundException;
import com.banasiak.CalCount.model.user.UserInfo;
import com.banasiak.CalCount.model.user.UserMacro;
import com.banasiak.CalCount.repo.UserInfoRepo;
import com.banasiak.CalCount.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepo userInfoRepo;
    @Override
    public boolean checkUserInfoValidation(UserInfo userInfo) {
        return !(userInfo.getWeight() < 30) && !(userInfo.getWeight() > 300) && !(userInfo.getHeight() < 100) && !(userInfo.getHeight() > 250) && userInfo.getAge() >= 0 && userInfo.getAge() <= 99;
    }

    @Override
    public UserInfo findUserInfoById(Long id) {
        return userInfoRepo.findById(id).orElseThrow(() -> new UserInfoNotFoundException(id) );
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoRepo.save(userInfo);
    }

    @Override
    public void saveUserMacro(UserInfo userInfo, UserMacro userMacro) {
        userInfo.setUserMacro(userMacro);
        userInfoRepo.save(userInfo);
    }

    @Override
    public Long findLastId() {
        return userInfoRepo.findLastId();
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        userInfoRepo.delete(userInfo);
    }

    @Override
    public void deleteUserInfoById(Long id) {
        userInfoRepo.deleteById(id);
    }

    @Override
    public UserMacro getUserMacro(UserInfo userInfo) {
        Optional<UserInfo> byId = userInfoRepo.findById(userInfo.getUserInfoId());
        return byId.get().getUserMacro();
    }

}
