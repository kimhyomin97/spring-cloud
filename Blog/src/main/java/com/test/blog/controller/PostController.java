package com.test.blog.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.test.blog.domain.ContentDto;
import com.test.blog.domain.Contents;
import com.test.blog.service.PostService;

import jakarta.servlet.ServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/blog")
public class PostController {

	@Autowired
	PostService service;

	@Autowired
	CustomConfig customConfig;
	
	

	@GetMapping(value = "name")
	public String getYourName(String nick, Model model) {
		model.addAttribute("configChange", "Your name is " + customConfig.getYourName() + ", nickname is " + nick);
		return "config";
	}

	@GetMapping("/")
	public String home() {
		return "form";
	}

	@PostMapping("/")
	public String form(@ModelAttribute ContentDto dto) {
		Contents post = Contents.builder().userid(dto.getUserid()).content(dto.getContent()).build();
		service.createPost(post);
		return "redirect:/";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("contents", service.postList());
		return "list";
	}
	
	 
	
    


	@Data
	@AllArgsConstructor
	static class ContentRequest {
		private String content;
	}

}
