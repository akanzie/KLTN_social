package com.social.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.social.demo.dto.UserDTO;
import com.social.demo.entity.UserEntity;
import com.social.demo.repository.UserRepository;
import com.social.demo.service.IUserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found"));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserDTO getUserByPhone(String phone) {
        UserEntity userEntity = userRepository.findByPhone(phone)
                .orElseThrow(() -> new EntityNotFoundException("User not found with phone: " + phone));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        if (userRepository.existsByEmail(userDTO.getEmail()))
            throw new RuntimeException("Email is already in use.");
        userEntity.setPassword(passwordEncoder.encode(userDTO.getUnconfirmedPassword())); // Đảm bảo mã hóa mật khẩu
        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUserDTO) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found"));
        modelMapper.map(updatedUserDTO, existingUser); // Ánh xạ thông tin từ DTO sang Entity
        return modelMapper.map(userRepository.save(existingUser), UserDTO.class);
    }

    @Override
    public boolean checkCurrentPassword(Long userId, String currentPassword) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found"));
        return passwordEncoder.matches(currentPassword, existingUser.getPassword());
    }

    public UserDTO changePassword(Long userId, String oldPassword, String newPassword) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found"));

        if (!passwordEncoder.matches(oldPassword, existingUser.getPassword())) {
            throw new RuntimeException("Old password is incorrect.");
        }

        existingUser.setPassword(passwordEncoder.encode(newPassword));
        UserEntity updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO authenticateUser(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
        if (userEntity != null && passwordEncoder.matches(password, userEntity.getPassword())) {
            return modelMapper.map(userEntity, UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> searchUser(String key) {
        List<UserEntity> foundUsers = userRepository.findByFirstNameContainingOrLastNameContaining(key, key);
        return foundUsers.stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }
}
