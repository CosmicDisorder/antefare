package com.github.cosmicdisorder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

    @RequestMapping(value = "register")
    public String register(Model model){

        return "antefare/register";
    }
}