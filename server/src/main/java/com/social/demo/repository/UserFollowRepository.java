package com.social.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.demo.entity.UserFollowEntity;

public interface UserFollowRepository extends JpaRepository<UserFollowEntity, Long> {

}
