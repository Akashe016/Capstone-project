package com.example.NewsApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.NewsApp.model.News;
import com.example.NewsApp.service.NewsService;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;
    
    
    @GetMapping("/")
    public String homePage() {
        return "addnews";
    }
    
    @GetMapping("/login")
    public String loginPage(){
    
    	return "login";
    }
    
    @GetMapping("/list")
    public String getAllUsers(Model model) {
        
    	List<News> list = newsService.getAllNewsList();
        model.addAttribute("list", list);
        return "list";
    }
    
    @GetMapping("/addnews")
    public String showAddNewsForm(Model model) {
        
    	model.addAttribute("news", new News());
        return "addnews";
    }

    @PostMapping("/addnews")
    public String addNews(@ModelAttribute("news") News news) {
        
    	newsService.createNews(news);
        return "redirect:/list";
    }   
}


