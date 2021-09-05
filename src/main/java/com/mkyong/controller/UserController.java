package com.mkyong.controller;

import com.mkyong.model.User;
import com.mkyong.service.ProductService;
import com.mkyong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController {

    private static String UserName = null;
    private static String Password = null;

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        LOGGER.info(UserName);
        model.addAttribute("username", UserName);
        return "index";
    }

    @GetMapping("/login")
    public String login_user(
            @RequestParam(value = "name_user", required = false) String username,
            @RequestParam(value = "password_user", required = false) String password,
            Model model) {

        User user = userService.login_user(username,password);
        UserName = username;
        Password = password;

        model.addAttribute("username", UserName);
        return "index";
    }



}