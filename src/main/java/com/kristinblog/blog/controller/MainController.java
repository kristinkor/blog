package com.kristinblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam(name="name", required = false, defaultValue = "Explorer") String name, Map<String, Object> model) {
        model.put("title", "Main page");
        model.put( "name",name);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About us");
        return "about";
    }




}