package com.example.demo.Controllers;


import com.example.demo.Entities.Role;
import com.example.demo.Entities.User;
import com.example.demo.Entities.UserRegistration;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class RegistrationController {

    private UserService user;
    @Autowired
    public RegistrationController(UserService user) {
        this.user = user;
    }

    @GetMapping("/registration")
    public String registration(Principal principal){
        if(principal != null){
            return "redirect:main";
        }
        return "registration";
    }
    @PostMapping("/registration")
    public String setUser(UserRegistration userRegistration, Model model){
        User user1 = user.findByUsername(userRegistration.getUsername());
        if(!userRegistration.getPassword().equals(userRegistration.getRepitPassword())){
            model.addAttribute("message", "Password don't equals");
            return "registration";
        }
        if(user1 != null){
            model.addAttribute("message", "User exists");
            return "registration";
        }
        User user2 = new User(userRegistration.getUsername(), userRegistration.getPassword(), List.of(Role.USER));
        user.addUser(user2);
        return "redirect:login";
    }
}
