package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.InboxEntity;

public interface InboxRepository extends JpaRepository<InboxEntity, Long> {

}