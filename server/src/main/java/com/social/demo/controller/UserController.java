package com.social.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.social.demo.dto.UserDTO;
import com.social.demo.service.IUserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        // Gọi phương thức từ service để tạo mới user
        UserDTO createdUser = userService.createUser(user);
        if (createdUser == null) {
            // Trả về HTTP 400 Bad Request nếu thông tin user không hợp lệ hoặc email đã tồn
            // tại
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Trả về HTTP 201 Created và dữ liệu của user đã được tạo mới
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Các phương thức xử lý yêu cầu HTTP
}
