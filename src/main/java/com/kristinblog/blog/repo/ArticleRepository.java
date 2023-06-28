package com.kristinblog.blog.repo;

import com.kristinblog.blog.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
