package com.example.NewsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.NewsApp.model.News;

@EnableJpaRepositories
@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

}
