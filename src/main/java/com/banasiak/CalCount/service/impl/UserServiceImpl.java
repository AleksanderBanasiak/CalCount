package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.exceptions.UserInfoNotFoundException;
import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.model.user.UserInfo;
import com.banasiak.CalCount.repo.UserRepo;
import com.banasiak.CalCount.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));



        userRepo.save(user);
    }

    @Override
    public void saveUsersInfo(User user, UserInfo userInfo) {
        user.setUserInfo(userInfo);
        userRepo.save(user);
    }
    @Override
    public User findUserByName(String name) {
        return userRepo.findUserInfoByUsername(name);
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserInfoNotFoundException(id));
    }



}
