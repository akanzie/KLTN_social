package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.UserCommentLikeEntity;

public interface UserCommentLikeRepository extends JpaRepository<UserCommentLikeEntity, Long>{
    
}
