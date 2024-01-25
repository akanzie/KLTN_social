package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.MediaPostEntity;

public interface ComponentPostRepository extends JpaRepository<MediaPostEntity,Long>{
    
}
