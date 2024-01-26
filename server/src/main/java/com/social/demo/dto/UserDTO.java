package com.social.demo.dto;

import java.time.LocalDate;

import com.social.demo.constants.UserStatus;

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
    private String phone;
    private String email;
    private String unconfirmedPassword;
    private int followerCount;
    private int friendCount;
    private UserStatus status;
}
