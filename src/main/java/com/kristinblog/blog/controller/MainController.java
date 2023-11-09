package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.Article;
import com.kristinblog.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ArticleRepository articleRepository;

//    @GetMapping("/")
//    public String home(@RequestParam(name="name", required = false, defaultValue = "Explorer") String name, Map<String, Object> model) {
//        model.put("title", "Main page");
//        model.put( "name",name);
//        return "about";
//    }

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("title", "Kristina Korzhenevskaya - Software Developer | Web Development Portfolio");
        // Modify this part to get the first three articles from the list
        List<Article> firstThreeArticles = new ArrayList<>();
        Iterator<Article> iterator = articles.iterator();
        for (int i = 0; i < 3 && iterator.hasNext(); i++) {
            firstThreeArticles.add(iterator.next());
        }

        model.addAttribute("articles", firstThreeArticles);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About me");
        return "about";
    }


    @GetMapping("/resume")
    public String resume(Model model) {
        model.addAttribute("title", "About me");
        return "resume-page";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("title", "Projects");
        return "projects-page";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact me");
        return "contact-page";
    }
    @GetMapping("/error")
    public String handleError() {
        return "error"; // "error" should be the name of your error page (e.g., error.html)
    }

}