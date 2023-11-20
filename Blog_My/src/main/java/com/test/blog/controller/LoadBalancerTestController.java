package com.test.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoadBalancerTestController {
	
	@Autowired
	MemberRestTemplateClient restTemplateClient;
	
	/**
	* RestTemplate 를 이용하여 이벤트 서비스의 REST API 호출
	*/
	@GetMapping(value = "/service/{name}")
		public String gift(@PathVariable("name")String name) {
		return "[MEMBER Service Name ] " + restTemplateClient.gift(name) ;
	}
}
