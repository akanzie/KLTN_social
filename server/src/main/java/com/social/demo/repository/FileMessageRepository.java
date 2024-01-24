package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.FileMessageEntity;

public interface FileMessageRepository extends JpaRepository<FileMessageEntity, Long> {

}
