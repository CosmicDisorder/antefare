package com.github.cosmicdisorder;

import com.github.cosmicdisorder.antefare.models.data.UserDao;
import com.github.cosmicdisorder.antefare.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping("")
    public String index(Model model) {

        return "user/index";
    }

    @RequestMapping("login")
    public String userLogin(Model model) {

        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(Model model, @ModelAttribute("inputEmail") String inputEmail,
            @ModelAttribute("inputPassword") String inputPassword, Errors errors) {
        if (errors.hasErrors()) {
            return "user/login";
        }
        ArrayList<User> Users = new ArrayList<User>();
        for(User user : userDao.findAll()) {
            Users.add(user);
            if(inputEmail == user.getEmail()) {
                User activeUser = user;
                if (inputPassword == activeUser.getPassword()) {
                    model.addAttribute("activeUser", activeUser.getName());
                    return "antefare/index";
                }
            }
        }


        return "user/login";
    }
}