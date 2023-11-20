package com.test.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

 
import com.test.blog.domain.Contents;
 
import com.test.blog.repository.ContentsRepository;
 

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	@Autowired
	private ContentsRepository postRepository;

	public Contents createPost(Contents content) {

		return postRepository.save(content);
	}

	public List<Contents> postList() {
		List<Contents> contents = new ArrayList();
		Iterable<Contents> contentsIterable = postRepository.findAll();
		contentsIterable.forEach(contents::add);
		return contents;
	}

    public Contents readOne(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}