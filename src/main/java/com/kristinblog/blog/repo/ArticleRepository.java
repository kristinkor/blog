package com.kristinblog.blog.repo;

import com.kristinblog.blog.models.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByTag(String tag);
}
