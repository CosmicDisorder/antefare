package com.github.cosmicdisorder.antefare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("")
    public String index(Model model) {

        return "admin/index";
    }

    @RequestMapping("login")
    public String adminLogin(Model model) {

        return "admin/login";
    }

}