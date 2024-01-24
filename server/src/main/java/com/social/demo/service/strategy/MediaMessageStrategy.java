package com.social.demo.service.strategy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.demo.dto.MessageDTO;
import com.social.demo.entity.FileMessageEntity;
import com.social.demo.entity.MessageEntity;
import com.social.demo.repository.FileMessageRepository;
import com.social.demo.service.MessageStrategy;

@Service
public class MediaMessageStrategy implements MessageStrategy {
    @Autowired
    private FileMessageRepository fileMesageRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageEntity sendMessage(MessageDTO messageDTO) {
        // Xử lý gửi tin nhắn với file đính kèm
        // Lưu đường dẫn file hoặc byte[] vào cơ sở dữ liệu
        FileMessageEntity fileMessageEntity = modelMapper.map(messageDTO, FileMessageEntity.class);
        // messageRepository.save(messageEntity);
        // Thêm xử lý lưu file vào ổ đĩa hoặc lưu đường dẫn file tùy vào yêu cầu của bạn
        return fileMesageRepository.save(fileMessageEntity);
    }
}
