package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.Article;
import com.kristinblog.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String home(@RequestParam(name="name", required = false, defaultValue = "Explorer") String name, Map<String, Object> model) {
        model.put("title", "Main page");
        model.put( "name",name);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        Iterable<Article> articles = articleRepository.findAll();

        // Modify this part to get the first three articles from the list
        List<Article> firstThreeArticles = new ArrayList<>();
        Iterator<Article> iterator = articles.iterator();
        for (int i = 0; i < 3 && iterator.hasNext(); i++) {
            firstThreeArticles.add(iterator.next());
        }

        model.addAttribute("articles", firstThreeArticles);
        return "about";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        //model.addAttribute("title", "About us");
        return "projects-page";
    }




}