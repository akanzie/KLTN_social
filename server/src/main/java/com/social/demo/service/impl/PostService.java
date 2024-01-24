package com.social.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.demo.entity.CommentEntity;

import com.social.demo.entity.PostEntity;

import com.social.demo.service.IPostService;

@Service
public class PostService implements IPostService {

    @Override
    public PostEntity createPost(Long userId, PostEntity post) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPost'");
    }

    @Override
    public PostEntity updatePost(Long postId, PostEntity updatedPost) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public void deletePost(Long postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    @Override
    public List<PostEntity> getPostsByUserId(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByUserId'");
    }

    @Override
    public int getLikeCountForPost(PostEntity post) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLikeCountForPost'");
    }

    @Override
    public List<CommentEntity> getCommentsForPost(PostEntity post) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentsForPost'");
    }

}
