package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
