package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.Article;
import com.kristinblog.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-main";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-add";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value="id") long articleId, Model model){
        Optional<Article> article = articleRepository.findById(articleId);
        ArrayList <Article> result = new ArrayList<>();
        article.ifPresent(result :: add);
        model.addAttribute("article", result);
        return "blog-details";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestPart String title, @RequestPart String anons, @RequestPart String full_text, Model model){
        Article post = new Article(title, anons, full_text);
        articleRepository.save(post);
        return "redirect:/blog";
    }



}
