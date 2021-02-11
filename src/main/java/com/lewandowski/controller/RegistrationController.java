package com.lewandowski.controller;

import com.lewandowski.entity.User;
import com.lewandowski.service.UserService;
import com.lewandowski.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private static final String VIEW_REGISTRATION_FORM = "authentication/register";

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userValidator", new UserValidator());

        return VIEW_REGISTRATION_FORM;
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("userValidator") UserValidator userValidator,
            BindingResult bindingResult,
            Model model) {

        if(bindingResult.hasErrors()) {
            return VIEW_REGISTRATION_FORM;
        }

        User existingUser = userService.findUserByUsername(userValidator.getUsername());
        if(existingUser != null) {
            model.addAttribute("userValidator", new UserValidator());
            model.addAttribute("registrationError", "Username already exists");

            return VIEW_REGISTRATION_FORM;
        }

        userService.save(userValidator);

        return "authentication/confirmation";
    }

}
