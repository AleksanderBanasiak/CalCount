package com.banasiak.CalCount.service;

import com.banasiak.CalCount.model.user.UserMacro;

public interface UserMacroService {

    UserMacro setCorrectUserMacro(UserMacro userMacro, UserMacro userMacroChanged);


    void saveUserMacro(UserMacro userMacro);




}
