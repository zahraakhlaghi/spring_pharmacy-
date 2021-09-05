package com.mkyong.service;

import com.mkyong.model.User;
import com.mkyong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login_user(String user_name,String password){
        return userRepository.login(user_name,password);
    }
}
