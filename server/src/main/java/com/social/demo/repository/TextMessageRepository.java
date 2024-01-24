package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.TextMessageEntity;

public interface TextMessageRepository extends JpaRepository<TextMessageEntity, Long> {
    // Các phương thức đặc biệt cho tin nhắn văn bản
}