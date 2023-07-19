package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.User;
import com.kristinblog.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String listUser(Model model){
    model.addAttribute("users", userRepository.findAll());
    return "user-list";
    }
}
