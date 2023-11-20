package com.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.member.domain.UserDto;
import com.test.member.domain.UserEntity;
import com.test.member.domain.UserResult;
import com.test.member.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor 
@RequestMapping("/member")
public class UserController {

	@Autowired
    UserService userService;
    
	@GetMapping("/")
    public String home() {
        return "form";
    }

    @PostMapping("/")
    public String create(@ModelAttribute UserDto userDto) {
        
        UserEntity users = userService.create(userDto);
        //return ResponseEntity.ok(new UserResult(users));
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String getUser(@PathVariable Long id, Model model) {
        
        UserEntity userOne = userService.readOne(id);         
       // return ResponseEntity.ok(new UserResult(users));        
        model.addAttribute("user", userOne);
        return "view";
    }
}