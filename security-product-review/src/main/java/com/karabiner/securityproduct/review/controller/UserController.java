package com.karabiner.securityproduct.review.controller;


import com.karabiner.securityproduct.review.entity.User;
import com.karabiner.securityproduct.review.model.UserModel;
import com.karabiner.securityproduct.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userDto){


        if(userService.isUserNameTaken(userDto.getUserName())){
            return "redirect:/register";
        }

        User user = userService.registerUser(userDto);

        return "success";
    }



}
