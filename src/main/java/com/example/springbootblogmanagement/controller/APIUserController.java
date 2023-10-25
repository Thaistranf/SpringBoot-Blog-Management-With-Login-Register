package com.example.springbootblogmanagement.controller;

import com.example.springbootblogmanagement.model.User;
import com.example.springbootblogmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class APIUserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView showFormRegister(){
        ModelAndView modelAndView = new ModelAndView("/user/register");
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(User user){
        userRepository.save(user);
        return ("redirect:/user/login");
    }

    @GetMapping("/login")
    public String showFormLogin(){
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String userName, String password){
        User user = userRepository.findByUserNameAndPassword(userName, password);
        if (user != null){
            return "/blog/list";
        } else {
            return "/user/login";
        }
    }
}
