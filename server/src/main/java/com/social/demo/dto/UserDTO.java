package com.social.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private String gender;
    private LocalDate birthday;
    private String avatarImage;
    private String phoneNumber;
    private boolean isPrivate;
    private String email;
    private String username;
    private String password;
    private int followerCount;
    private int followingCount;
    private int postCount;
}
