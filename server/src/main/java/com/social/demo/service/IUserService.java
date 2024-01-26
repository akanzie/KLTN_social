package com.social.demo.service;

import java.util.List;

import com.social.demo.dto.UserDTO;

public interface IUserService {

    UserDTO getUserById(Long userId);

    UserDTO getUserByEmail(String email);

    UserDTO getUserByPhone(String phone);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long userId, UserDTO updatedUser);

    boolean checkCurrentPassword(Long userId, String currentPassword);

    UserDTO changePassword(Long userId, String oldPassword, String newPassword);

    UserDTO authenticateUser(String username, String password);

    List<UserDTO> searchUser(String key);
}
