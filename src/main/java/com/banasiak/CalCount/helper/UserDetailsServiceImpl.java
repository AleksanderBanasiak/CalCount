package com.banasiak.CalCount.helper;

import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserInfoByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not found user!");
        }
        return new CustomUserDetails(user);
    }
}
