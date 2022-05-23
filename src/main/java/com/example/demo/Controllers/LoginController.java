package com.example.demo.Controllers;


import com.example.demo.Entities.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private UserService user;
    @Autowired
    public LoginController(UserService user) {
        this.user = user;
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(name = "error", required = false) String b, Model model){
        if("".equals(b)){
            model.addAttribute("message", "User is not found");
            return "login";
        }
        return "login";
    }
}
