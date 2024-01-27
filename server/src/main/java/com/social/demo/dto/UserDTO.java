package com.social.demo.dto;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String username;
    private String bio;
    private String gender;
    private MultipartFile avatarImage;
    private String phone;
    private String email;
    private String unconfirmedPassword;
    private int postCount;
    private int followerCount;
    private int followingCount;
    private boolean isPrivate;
}
