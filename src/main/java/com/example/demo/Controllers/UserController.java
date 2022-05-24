package com.example.demo.Controllers;

import com.example.demo.Entities.Application;
import com.example.demo.Entities.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public String getMain(Principal principal){
        if(principal == null){
            return "main1";
        }
        else {
            return "main2";
        }
    }

    @GetMapping("/list")
    public String getApp(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("list", user.getApplications());
        return "app";
    }

    @GetMapping("/addApp")
    public String getAddApp(){
        return "addApp";
    }

    @PostMapping ("/addApp")
    public String addApp(Application application, Principal principal, Model model){
        if(application.getName().equals("")){
            model.addAttribute("message", "Null application");
            return "addApp";
        }
        userService.addApplication(principal.getName(), application);
        return "redirect:main";
    }

}
