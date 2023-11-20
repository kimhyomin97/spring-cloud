package com.test.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 

import com.test.blog.domain.ContentDto;
import com.test.blog.domain.Contents;
 
import com.test.blog.service.PostService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PostController {

	@Autowired
	PostService service;
	
	@Autowired
	CustomConfig customConfig;

    @GetMapping("/")
    public String home() {
        return "form";
    }

    @PostMapping("/")
    public String form(@ModelAttribute ContentDto dto) {
    	Contents post = Contents.builder()
         		.userid(dto.getUserid())
                 .content(dto.getContent())
                 .build();
    	service.createPost(post);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contents", service.postList());
        return "list";
    }
    
    @GetMapping(value = "name")
    public String getYourName(String nick, Model model) {
    	model.addAttribute("configChange", "Your name is " + customConfig.getYourName() + ", nickname is " + nick);
    	return "config";
    }

    @Data
    @AllArgsConstructor
    static class ContentRequest{
        private String content;
    }
}
