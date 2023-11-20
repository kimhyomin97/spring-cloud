package com.test.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.member.domain.UserEntity;

 

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
