package com.social.demo.repository;

import java.util.List;

import com.social.demo.entity.UserEntity;
import com.social.demo.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findBySenderAndReceiver(UserEntity sender, UserEntity receiver);
}
