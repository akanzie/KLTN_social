package com.social.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY)
    private List<CommentEntity> replies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private CommentEntity parentComment;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<UserCommentLikeEntity> usersLiked = new ArrayList<>();

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime commentedDate;

    // Getters and setters
}