package com.github.cosmicdisorder.antefare.controllers;

import com.github.cosmicdisorder.antefare.models.User;
import com.github.cosmicdisorder.antefare.service.SecurityServiceImpl;
import com.github.cosmicdisorder.antefare.service.UserServiceImpl;
import com.github.cosmicdisorder.antefare.validator.UserValidator;
import com.github.cosmicdisorder.antefare.service.SecurityService;
import com.github.cosmicdisorder.antefare.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("antefare")
public class AntefareController {

    String[] locations = {"St. Louis", "Chicago", "Indianapolis"};

    @RequestMapping("")
    public String index(Model model) {


        model.addAttribute("locations", locations);

        return "antefare/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String cityIndex(@RequestParam(defaultValue = "") int locationId, Model model) {

        model.addAttribute("location", locations[locationId]);
        model.addAttribute("title", "Antefare: " + locations[locationId]);
        model.addAttribute("locations", locations);

        return "antefare/index";
    }
    @GetMapping(value = "/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult, Model model) {

        UserValidator userValidator = new UserValidator();
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        UserServiceImpl userService = new UserServiceImpl();
        userService.save(userForm);

        SecurityServiceImpl securityService = new SecurityServiceImpl();
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }
}