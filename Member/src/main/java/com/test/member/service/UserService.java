package com.test.member.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.test.member.domain.UserDto;
import com.test.member.domain.UserEntity;
import com.test.member.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(UserDto userDto) {
        
        UserEntity userEntity = UserEntity.builder()
        		.username(userDto.getUsername())
        		.userid(userDto.getUserid())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .build();
        
        return userRepository.save(userEntity);
    }

    public UserEntity readOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}