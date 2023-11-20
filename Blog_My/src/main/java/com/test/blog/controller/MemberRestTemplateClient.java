package com.test.blog.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class MemberRestTemplateClient {
	
	RestTemplate restTemplate;
	
	public MemberRestTemplateClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String gift(String name) {
		ResponseEntity<String> restExchange =
			restTemplate.exchange(
				"http://member-service/service/{name}",
				HttpMethod.GET,
				null, String.class, name
			);
		System.out.println(restExchange.getBody());
		return restExchange.getBody();
	}
}
