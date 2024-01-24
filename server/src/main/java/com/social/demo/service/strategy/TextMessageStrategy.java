package com.social.demo.service.strategy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.demo.constants.MessageStatus;
import com.social.demo.dto.MessageDTO;
import com.social.demo.entity.MessageEntity;
import com.social.demo.entity.TextMessageEntity;
import com.social.demo.repository.TextMessageRepository;
import com.social.demo.service.MessageStrategy;

@Service
public class TextMessageStrategy implements MessageStrategy {
    @Autowired
    private TextMessageRepository textMessageRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageEntity sendMessage(MessageDTO messageDTO) {
        TextMessageEntity textMessageEntity = modelMapper.map(messageDTO, TextMessageEntity.class);
        textMessageEntity.setStatus(MessageStatus.NORMAL);
        return textMessageRepository.save(textMessageEntity);
    }
}
