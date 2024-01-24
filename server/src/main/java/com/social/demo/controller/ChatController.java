package com.social.demo.controller;

import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.social.demo.dto.MessageDTO;
import com.social.demo.service.IMessageService;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {
    @Autowired
    private IMessageService iMessageService;

    @PostMapping
    public ResponseEntity<MessageDTO> sendFileMessage(@ModelAttribute MessageDTO request) {
        MessageDTO message = iMessageService.sendMessage(request);

        // Trả về HTTP 201 Created và dữ liệu của user đã được tạo mới
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

}
