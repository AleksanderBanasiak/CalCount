package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.dto.UserInfoDto;
import com.banasiak.CalCount.dto.UserInfoShowDto;
import com.banasiak.CalCount.model.user.*;
import com.banasiak.CalCount.service.UserInfoService;
import com.banasiak.CalCount.service.UserMacroService;
import com.banasiak.CalCount.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.banasiak.CalCount.calculation.UserCaloricDemand.*;
import static com.banasiak.CalCount.mapper.UserInfoDtoMapper.mapUserInfoDtoToUserInfo;
import static com.banasiak.CalCount.mapper.UserInfoDtoMapper.mapUserInfoToUserInfoDto;
import static com.banasiak.CalCount.mapper.UserInfoShowMapper.mapUserInfoDtoToUserInfoShowDto;

@Controller
@RequiredArgsConstructor
public class UserProfileController {

    private final UserService userService;
    private final UserMacroService userMacroService;
    private final UserInfoService userInfoService;
    private UserMacro macro = new UserMacro();


    @GetMapping("/checkInfo")
    public String checkIsInfoSet(Principal principal, Model model) {
        if(userService.findUserByName(principal.getName()).getUserInfo() == null){
            model.addAttribute("name", principal.getName());
            model.addAttribute("info", new UserInfoDto());
            return "loadUserDetails";
        }
        if(userService.findUserByName(principal.getName()).getUserInfo().getUserMacro() == null){
            setMacro(userService.findUserByName(principal.getName()).getUserInfo());
            modelsForMacro(model, userService.findUserByName(principal.getName()),
                    mapUserInfoDtoToUserInfoShowDto(mapUserInfoToUserInfoDto(userService.findUserByName(principal.getName()).getUserInfo())));
            return "saveUserMacro";
        }
      return "redirect:/today";
    }

    @GetMapping("/user/macro/{name}")
    public String showUserMacro(@PathVariable String name, Model model){
        macro = userService.findUserByName(name).getUserInfo().getUserMacro();
        modelsForMacro(model, userService.findUserByName(name),
                mapUserInfoDtoToUserInfoShowDto(mapUserInfoToUserInfoDto(userService.findUserByName(name).getUserInfo())));
        return "saveUserMacro";
    }

    private void modelsForMacro(Model model, User user, UserInfoShowDto userInfoShowDto){
        model.addAttribute("userInfo",  userInfoShowDto);
        model.addAttribute("user", user);
        model.addAttribute("usersMacro", macro);
        model.addAttribute("macro", new UserMacro());
    }

    @PostMapping("/users/add/macro")
    public String setUserInfo(@ModelAttribute UserInfoDto userInfoDto, Model model,Principal principal){
        UserInfo userInfo = mapUserInfoDtoToUserInfo(userInfoDto);
        if(!userInfoService.checkUserInfoValidation(userInfo)){
            model.addAttribute("infoNotValid", true);
            model.addAttribute("name", principal.getName());
            model.addAttribute("info", new UserInfoDto());
            return "loadUserDetails";
        }
//        if(userService.findUserByName(principal.getName()).getUserInfo()!= null){
//            Long userInfoId = userService.findUserByName(principal.getName()).getUserInfo().getUserInfoId();
//            User userByName = userService.findUserByName(principal.getName());
//            userByName.setUserInfo(null);
//            userService.saveUser(userByName);
//            userInfoService.deleteUserInfoById(userInfoId);
//        }
        userInfoService.saveUserInfo(userInfo);
        userService.saveUsersInfo(userService.findUserByName(principal.getName()), userInfo);
        setMacro(userInfo);
        modelsForMacro(model, userService.findUserByName(principal.getName()), mapUserInfoDtoToUserInfoShowDto(userInfoDto));
        return "saveUserMacro";
    }
    @PostMapping("/user/info")
    public String processMacroForm(@ModelAttribute UserMacro userMacro, Principal principal) {
        UserMacro correctUserMacro = userMacroService.setCorrectUserMacro(macro, userMacro);
        userMacroService.saveUserMacro(userMacroService.setCorrectUserMacro(macro, userMacro));
        userInfoService.saveUserMacro(userService.findUserByName(principal.getName()).getUserInfo(), correctUserMacro);
        return "redirect:/today";
    }

    @GetMapping("/changeInfo/{id}")
    private String changeUserInfo(@PathVariable Long id, Model model){
        User userById = userService.findUserById(id);
        model.addAttribute("name", userById.getUsername());
        model.addAttribute("info", userById.getUserInfo());
        return "loadUserDetails";
    }

    @GetMapping("/bulk/{id}")
    private String bulk(@PathVariable Long id, Model model){
        macro = calculateMacroOfDifferentNutrition(macro, 115);
        modelsToChangeNutrition(model, userService.findUserById(id));
        return "saveUserMacro";
    }

    @GetMapping("/cut/{id}")
    private String cut(@PathVariable Long id, Model model){
        macro = calculateMacroOfDifferentNutrition(macro, 85);
        modelsToChangeNutrition(model, userService.findUserById(id));
        return "saveUserMacro";
    }

    private void modelsToChangeNutrition(Model model, User user){
        model.addAttribute("userInfo", user.getUserInfo());
        model.addAttribute("usersMacro", macro);
        model.addAttribute("user", user);
        model.addAttribute("macro", new UserMacro());
    }

    public void setMacro(UserInfo userInfo) {
        macro.setKcal(calculateCaloricDemand(userInfo));
        macro.setProtein(calculateProtein(userInfo));
        macro.setFat(calculateFat(userInfo));
        macro.setFiber(calculateFiber(userInfo));
        macro.setCarbs(calculateCarbs(macro));
    }

}
