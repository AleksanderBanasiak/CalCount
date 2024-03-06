package com.banasiak.CalCount.service.impl;

import com.banasiak.CalCount.model.user.UserMacro;
import com.banasiak.CalCount.repo.UserMacroRepo;
import com.banasiak.CalCount.service.UserMacroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMacroServiceImpl implements UserMacroService {

    private final UserMacroRepo macroRepo;

    @Override
    public UserMacro setCorrectUserMacro(UserMacro userMacro, UserMacro userMacroChanged) {

        if(userMacroChanged.getKcal() == 0){
            userMacroChanged.setKcal(userMacro.getKcal());
        }
        if(userMacroChanged.getProtein() == 0){
            userMacroChanged.setProtein(userMacro.getProtein());
        }
        if(userMacroChanged.getCarbs() == 0){
            userMacroChanged.setCarbs(userMacro.getCarbs());
        }
        if(userMacroChanged.getFiber() == 0){
            userMacroChanged.setFiber(userMacro.getFiber());
        }
        if(userMacroChanged.getFat() == 0){
            userMacroChanged.setFat(userMacro.getFat());
        }

        return userMacroChanged;
    }

    @Override
    public void saveUserMacro(UserMacro userMacro) {
        macroRepo.save(userMacro);
    }

}
