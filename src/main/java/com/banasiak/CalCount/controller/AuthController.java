package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.dto.AuthRequestDto;
import com.banasiak.CalCount.dto.UserRequest;
import com.banasiak.CalCount.service.impl.JwtService;
import com.banasiak.CalCount.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.banasiak.CalCount.mapper.UserRequestMapper.mapUserRequestMapperToUser;
import static com.banasiak.CalCount.validation.UserValidation.checkNameValidation;
import static com.banasiak.CalCount.validation.UserValidation.checkPassValidation;


@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @PostMapping("/login")
    public String authenticateAndGetToken(@ModelAttribute AuthRequestDto authRequestDTO, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));

            if (authentication.isAuthenticated()) {
                String accessToken = jwtService.GenerateToken(authRequestDTO.getUsername());
                ResponseCookie cookie = ResponseCookie.from("accessToken", accessToken)
                        .httpOnly(true)
                        .secure(false)
                        .path("/")
                        .maxAge(1800)
                        .build();
                response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
                return "redirect:/checkInfo";
            } else {
                throw new UsernameNotFoundException("Invalid user request");
            }
        } catch (Exception e) {
            return "redirect:/auth/login?error";
        }
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserRequest user, Model model){
        if(userService.findUserByName(user.getUsername()) ==null){
            if(!checkNameValidation(user.getUsername())){
                model.addAttribute("userisnotvalid", true);
                return "register";
            }else if(!checkPassValidation(user.getPassword())){
                model.addAttribute("passisnotvalid", true);
                return "register";
            } else {
                userService.saveUser(mapUserRequestMapperToUser(user));
                return "redirect:/auth/register?success";
            }
        }else {
            model.addAttribute("userexists", true);
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("accessToken")) {
                cookie.setMaxAge(0);
                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "redirect:/auth/login?logout";
    }

}
