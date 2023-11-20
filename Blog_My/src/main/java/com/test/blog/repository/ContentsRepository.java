package com.test.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.blog.domain.Contents;

public interface ContentsRepository extends  JpaRepository<Contents, Long> {
}