package com.social.demo.service;

import java.util.List;

import com.social.demo.entity.CommentEntity;
import com.social.demo.entity.PostEntity;
import com.social.demo.entity.UserEntity;

public interface ICommentService {

    /**
     * Thêm một bình luận mới vào bài đăng.
     *
     * @param user    Người dùng thực hiện bình luận.
     * @param post    Bài đăng mà bình luận được thêm vào.
     * @param content Nội dung của bình luận.
     * @return Đối tượng bình luận đã được tạo.
     */
    CommentEntity addComment(UserEntity user, PostEntity post, String content);

    /**
     * Xóa một bình luận dựa trên người dùng và đối tượng bình luận.
     *
     * @param user    Người dùng thực hiện xóa bình luận.
     * @param comment Đối tượng bình luận cần xóa.
     */
    void deleteComment(UserEntity user, CommentEntity comment);

    /**
     * Người dùng thích một bình luận.
     *
     * @param user    Người dùng thực hiện thích.
     * @param comment Đối tượng bình luận được thích.
     */
    void likeComment(UserEntity user, CommentEntity comment);

    /**
     * Lấy danh sách các phản hồi cho một bình luận.
     *
     * @param parentComment Bình luận cha mà bạn muốn lấy các phản hồi.
     * @return Danh sách các đối tượng bình luận phản hồi.
     */
    List<CommentEntity> getRepliesForComment(CommentEntity parentComment);

    /**
     * Lấy danh sách người dùng đã thích một bình luận.
     *
     * @param comment Bình luận mà bạn muốn lấy danh sách người dùng thích.
     * @return Danh sách người dùng đã thích bình luận.
     */
    List<UserEntity> getUsersWhoLikedComment(CommentEntity comment);

    /**
     * Lấy số lượng lượt thích cho một bình luận.
     *
     * @param comment Bình luận mà bạn muốn kiểm tra số lượng lượt thích.
     * @return Số lượng lượt thích cho bình luận.
     */
    int getLikeCountForComment(CommentEntity comment);

    /**
     * Lấy số lượng phản hồi cho một bình luận.
     *
     * @param comment Bình luận mà bạn muốn kiểm tra số lượng phản hồi.
     * @return Số lượng phản hồi cho bình luận.
     */
    int getReplyCountForComment(CommentEntity comment);

    /**
     * Chỉnh sửa nội dung của một bình luận.
     *
     * @param user       Người dùng thực hiện chỉnh sửa.
     * @param comment    Bình luận cần được chỉnh sửa.
     * @param newContent Nội dung mới của bình luận.
     * @return Đối tượng bình luận đã được chỉnh sửa.
     */
    CommentEntity editComment(UserEntity user, CommentEntity comment, String newContent);
}
