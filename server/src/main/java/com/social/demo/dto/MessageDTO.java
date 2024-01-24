package com.social.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import com.social.demo.constants.MessageType;

import lombok.Data;

@Data
public class MessageDTO {
    private Long id;
    private long senderId;
    private long receiverId;
    private String content;
    private MessageType messageType;
    private MultipartFile file;
    
}
