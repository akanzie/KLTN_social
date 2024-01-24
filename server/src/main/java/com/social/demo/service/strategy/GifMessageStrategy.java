package com.social.demo.service.strategy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.demo.dto.MessageDTO;
import com.social.demo.entity.GifMessageEntity;
import com.social.demo.entity.MessageEntity;
import com.social.demo.repository.GifMessageRepository;
import com.social.demo.service.MessageStrategy;
@Service
public class GifMessageStrategy implements MessageStrategy {
    @Autowired
    private GifMessageRepository gifMessageRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageEntity sendMessage(MessageDTO messageDTO) {
        // Xử lý gửi tin nhắn với file đính kèm
        // Lưu đường dẫn file hoặc byte[] vào cơ sở dữ liệu
        GifMessageEntity gifMessageEntity = modelMapper.map(messageDTO, GifMessageEntity.class);
        // messageRepository.save(messageEntity);
        // Thêm xử lý lưu file vào ổ đĩa hoặc lưu đường dẫn file tùy vào yêu cầu của bạn
        return gifMessageRepository.save(gifMessageEntity);
    }
}
