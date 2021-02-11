package com.lewandowski.controller;

import com.lewandowski.entity.User;
import com.lewandowski.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/profile")
    public String showUserProfilePage(Authentication auth, Model model) {

        User loggedUser = userService.findUserByUsername(auth.getName());
        model.addAttribute("loggedUser", loggedUser);

        return "user/profile";
    }

}
