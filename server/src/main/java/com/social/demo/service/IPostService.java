package com.social.demo.service;

import java.util.List;

import com.social.demo.entity.CommentEntity;
import com.social.demo.entity.PostEntity;

public interface IPostService {

    /**
     * Tạo một bài đăng mới cho người dùng có ID được cung cấp.
     *
     * @param userId ID của người dùng tạo bài đăng.
     * @param post   Đối tượng bài đăng sẽ được tạo.
     * @return Đối tượng bài đăng đã được tạo.
     */
    public PostEntity createPost(Long userId, PostEntity post);

    /**
     * Cập nhật thông tin của một bài đăng đã tồn tại.
     *
     * @param postId      ID của bài đăng cần cập nhật.
     * @param updatedPost Đối tượng bài đăng được cập nhật.
     * @return Đối tượng bài đăng đã được cập nhật.
     */
    public PostEntity updatePost(Long postId, PostEntity updatedPost);

    /**
     * Xóa một bài đăng dựa trên ID của nó.
     *
     * @param postId ID của bài đăng cần xóa.
     */
    public void deletePost(Long postId);

    /**
     * Lấy danh sách các bài đăng của một người dùng dựa trên ID của người dùng đó.
     *
     * @param userId ID của người dùng.
     * @return Danh sách các đối tượng bài đăng của người dùng.
     */
    public List<PostEntity> getPostsByUserId(Long userId);

    /**
     * Lấy số lượng lượt thích cho một bài đăng.
     *
     * @param post Bài đăng cần kiểm tra số lượng lượt thích.
     * @return Số lượng lượt thích cho bài đăng.
     */
    public int getLikeCountForPost(PostEntity post);

    /**
     * Lấy danh sách các bình luận của một bài đăng.
     *
     * @param post Bài đăng cần lấy danh sách bình luận.
     * @return Danh sách các đối tượng bình luận của bài đăng.
     */
    public List<CommentEntity> getCommentsForPost(PostEntity post);
}
