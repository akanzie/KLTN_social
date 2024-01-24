package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{
    
}
