package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.GifMessageEntity;

public interface GifMessageRepository extends JpaRepository<GifMessageEntity, Long> {

}
