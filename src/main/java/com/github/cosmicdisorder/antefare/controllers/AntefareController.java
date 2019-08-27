package com.github.cosmicdisorder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("antefare")
public class AntefareController {

    @RequestMapping("")
    public String index(Model model) {

        String[] locations = {"St. Louis", "Chicago", "Indianapolis"};
        model.addAttribute("locations", locations);

        return "antefare/index";
    }
}