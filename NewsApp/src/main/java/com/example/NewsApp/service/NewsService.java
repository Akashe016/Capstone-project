package com.example.NewsApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NewsApp.model.News;
import com.example.NewsApp.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	NewsRepository newsRepository;
		
	public News createNews(News news) {
		
		return newsRepository.save(news);	
	}
	
	
	public List<News> getAllNewsList() {
		
		return newsRepository.findAll();
	}
}
