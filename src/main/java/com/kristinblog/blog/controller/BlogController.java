package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.Article;
import com.kristinblog.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        if(!articleRepository.existsById(articleId)){
            return "redirect:/blog";
        }
        Optional<Article> article = articleRepository.findById(articleId);
        ArrayList <Article> result = new ArrayList<>();
        article.ifPresent(result :: add);
        model.addAttribute("article", result);
        return "blog-details";
    }

    @PostMapping("/blog/add")
    public String blogArticleAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, @RequestParam String tag, Model model){
        Article article = new Article(title, anons, fullText, tag);
        articleRepository.save(article);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value="id") long articleId, Model model){
        if(!articleRepository.existsById(articleId)){
            return "redirect:/blog";
        }
        Optional<Article> article = articleRepository.findById(articleId);
        ArrayList <Article> result = new ArrayList<>();
        article.ifPresent(result :: add);
        model.addAttribute("article", result);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogArticleUpdate(@PathVariable(value="id") long articleId, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText, @RequestParam String tag, Model model){
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.setTitle(title);
        article.setTitle(anons);
        article.setTag(tag);
        article.setTitle(fullText);
        articleRepository.save(article);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogArticleDelete(@PathVariable(value="id") long articleId, Model model){
        Article article = articleRepository.findById(articleId).orElseThrow();
        articleRepository.delete(article);
        return "redirect:/blog";
    }

    @PostMapping("filter")
    public String blogArticlesFilter(@RequestParam String filter, Map<String,Object> model){
        List<Article> articles = articleRepository.findByTag(filter);
        model.put("articles", articles);
        return "blog-main";
    }

}
