package com.github.cosmicdisorder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("")
    public String index(Model model) {

        return "user/index";
    }

    @RequestMapping("login")
    public String userLogin(Model model) {

        return "user/login";
    }

}