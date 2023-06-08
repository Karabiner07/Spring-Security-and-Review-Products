package com.karabiner.securityproduct.review.service;

import com.karabiner.securityproduct.review.entity.User;
import com.karabiner.securityproduct.review.model.UserModel;


public interface UserService {

    public User registerUser(UserModel userModel);

    public boolean isUserNameTaken(String userEmail);
}
