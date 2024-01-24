package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.ComponentPostEntity;

public interface ComponentPostRepository extends JpaRepository<ComponentPostEntity,Long>{
    
}
