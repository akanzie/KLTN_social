package com.social.demo.service.strategy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.demo.dto.MessageDTO;
import com.social.demo.entity.MessageEntity;
import com.social.demo.entity.TextMessageEntity;
import com.social.demo.repository.TextMessageRepository;
import com.social.demo.service.MessageStrategy;
@Service
public class LinkMessageStrategy implements MessageStrategy {
    @Autowired
    private TextMessageRepository textMessageRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageEntity sendMessage(MessageDTO messageDTO) {
        // Xử lý gửi tin nhắn với file đính kèm
        // Lưu đường dẫn file hoặc byte[] vào cơ sở dữ liệu
        TextMessageEntity textMessageEntity = modelMapper.map(messageDTO, TextMessageEntity.class);
        // messageRepository.save(messageEntity);
        // Thêm xử lý lưu file vào ổ đĩa hoặc lưu đường dẫn file tùy vào yêu cầu của bạn
        return textMessageRepository.save(textMessageEntity);
    }
}
