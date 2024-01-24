package com.social.demo.service;

import java.util.List;

import com.social.demo.entity.UserEntity;

public interface IFollowService {

    /**
     * Người dùng theo dõi một người dùng khác.
     *
     * @param follower  Người dùng theo dõi.
     * @param following Người dùng được theo dõi.
     */
    void followUser(UserEntity follower, UserEntity following);

    /**
     * Người dùng hủy theo dõi một người dùng khác.
     *
     * @param follower  Người dùng hủy theo dõi.
     * @param following Người dùng không còn được theo dõi.
     */
    void unfollowUser(UserEntity follower, UserEntity following);

    /**
     * Hiển thị danh sách người dùng mà một người dùng đang theo dõi.
     *
     * @param follower Người dùng đang theo dõi.
     * @return Danh sách người dùng mà người dùng đang theo dõi.
     */
    List<UserEntity> getFollowingList(UserEntity follower);

    /**
     * Hiển thị danh sách người dùng đang theo dõi một người dùng.
     *
     * @param following Người dùng được theo dõi.
     * @return Danh sách người dùng đang theo dõi người dùng được chỉ định.
     */
    List<UserEntity> getFollowersList(UserEntity following);

    /**
     * Xóa một người đang theo dõi từ danh sách theo dõi của một người dùng.
     *
     * @param follower  Người dùng chủ động xóa theo dõi.
     * @param following Người dùng bị xóa khỏi danh sách theo dõi.
     */
    void removeFollower(UserEntity follower, UserEntity following);
}
