package com.digispike.demo.controller;

import com.digispike.demo.model.User;
import com.digispike.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Devon Ravihansa on 8/23/2017.
 */
@Controller
public class DefaultController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("view", "index");
        return "layouts/default";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("view", "signup");
        return "layouts/default";
    }

    @PostMapping("/signup")
    public String signupProcess(@RequestParam String username, @RequestParam String password, Model model){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        model.addAttribute("view", "signup");
        model.addAttribute("message", username + " saved successfully!");
        return "layouts/default";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("view", "login");
        return "layouts/default";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("view", "dashboard");
        model.addAttribute("users", userRepository.findAll());
        return "layouts/default";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("view", "home");
        return "layouts/default";
    }

    @GetMapping("/403")
    public String accessDenied(Model model){
        model.addAttribute("view", "error/403");
        return "layouts/default";
    }
}
