package com.karabiner.securityproduct.review.service;

import com.karabiner.securityproduct.review.entity.User;
import com.karabiner.securityproduct.review.model.UserModel;
import com.karabiner.securityproduct.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {

        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setUserEmail(userModel.getUserEmail());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole("USER");
        userRepository.save(user);

        return user;
    }

    public boolean isUserNameTaken(String userName){
        return userRepository.existsByUserName(userName);
    }

}
