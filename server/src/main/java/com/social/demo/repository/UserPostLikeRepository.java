package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.UserPostLikeEntity;

public interface UserPostLikeRepository extends JpaRepository<UserPostLikeEntity, Long> {
    
}
