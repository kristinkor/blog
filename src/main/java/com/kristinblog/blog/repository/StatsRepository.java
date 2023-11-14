package com.kristinblog.blog.repository;

import com.kristinblog.blog.models.Stats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends CrudRepository<Stats, Integer> {
    
}