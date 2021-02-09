package com.lewandowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "authentication/login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "authentication/accessDenied";
    }

}
