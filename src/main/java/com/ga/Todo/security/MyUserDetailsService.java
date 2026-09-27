package com.ga.Todo.security;

import com.ga.Todo.Model.User;
import com.ga.Todo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserService userService;
    //
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = userService.findByEmailAddress(email);
        return new MyUserDetails(user);
    }
}
