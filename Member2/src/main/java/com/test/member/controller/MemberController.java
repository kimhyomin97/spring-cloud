package com.test.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	@GetMapping("/service/{name}")
	public String getServiceName(ServletRequest req) {
		return "Member-Service #2 / port is " + req.getServerPort();
	}
	
	@GetMapping(value = "/name/{nick}")
	public String getYourName(ServletRequest req, @PathVariable("nick") String nick) {
		return "Member-Service #2" + " / nickname is " + nick + " / port is " + req.getServerPort();
	}
}
