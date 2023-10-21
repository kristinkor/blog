package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.Article;
import com.kristinblog.blog.models.User;
import com.kristinblog.blog.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        if (filter != null && !filter.isEmpty()) {
            articles = articleRepository.findByTag(filter);
        } else {
            articles = articleRepository.findAll();
        }
        model.addAttribute("articles", articles);
        model.addAttribute("filter", filter);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogArticleAdd(@AuthenticationPrincipal User user, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText, @RequestParam String tag, Map<String, Object> model) {
        Article article = new Article(title, anons, fullText, tag, user);
        articleRepository.save(article);
        Iterable<Article> articles = articleRepository.findAll();
        model.put("articles", articles);
        return "redirect:/blog-main";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long articleId, Model model) {
        if (!articleRepository.existsById(articleId)) {
            return "redirect:/blog-main";
        }
        Optional<Article> article = articleRepository.findById(articleId);
        ArrayList<Article> result = new ArrayList<>();
        article.ifPresent(result::add);
        model.addAttribute("article", result);
        return "blog-details";
    }


    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long articleId, Model model) {
        if (!articleRepository.existsById(articleId)) {
            return "redirect:/blog-main";
        }
        Optional<Article> article = articleRepository.findById(articleId);
        ArrayList<Article> result = new ArrayList<>();
        article.ifPresent(result::add);
        model.addAttribute("article", result);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogArticleUpdate(@PathVariable(value = "id") long articleId, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText, @RequestParam String tag, Model model) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.setTitle(title);
        article.setTitle(anons);
        article.setTag(tag);
        article.setTitle(fullText);
        articleRepository.save(article);
        return "redirect:/blog-main";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogArticleDelete(@PathVariable(value = "id") long articleId, Model model) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        articleRepository.delete(article);
        return "redirect:/blog-main";
    }

}
