package com.social.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.demo.constants.MessageType;
import com.social.demo.dto.MessageDTO;
import com.social.demo.dto.UserDTO;
import com.social.demo.service.IMessageService;
import com.social.demo.service.MessageStrategy;
import com.social.demo.service.strategy.FileMessageStrategy;
import com.social.demo.service.strategy.GifMessageStrategy;
import com.social.demo.service.strategy.LinkMessageStrategy;
import com.social.demo.service.strategy.MediaMessageStrategy;
import com.social.demo.service.strategy.TextMessageStrategy;

import jakarta.annotation.PostConstruct;

@Service
public class MessageService implements IMessageService {
    @Autowired
    private ModelMapper modelMapper;
    private Map<MessageType, MessageStrategy> strategyMap;
    @Autowired
    private TextMessageStrategy textMessageStrategy;
    @Autowired
    private FileMessageStrategy fileMessageStrategy;
    @Autowired
    private MediaMessageStrategy mediaMessageStrategy;
    @Autowired
    private LinkMessageStrategy linkMessageStrategy;
    @Autowired
    private GifMessageStrategy gifMessageStrategy;

    @PostConstruct
    private void initStrategies() {
        strategyMap = new HashMap<>();
        strategyMap.put(MessageType.TEXT, textMessageStrategy);
        strategyMap.put(MessageType.FILE, fileMessageStrategy);
        strategyMap.put(MessageType.MEDIA, mediaMessageStrategy);
        strategyMap.put(MessageType.LINK, linkMessageStrategy);
        strategyMap.put(MessageType.GIF, gifMessageStrategy);
    }

    @Override
    public MessageDTO sendMessage(MessageDTO messageDTO) {
        MessageType messageType = messageDTO.getMessageType();
        MessageStrategy strategy = strategyMap.get(messageType);

        if (strategy == null) {
            throw new UnsupportedOperationException("Unsupported message type");
        }

        return modelMapper.map(strategy.sendMessage(messageDTO), MessageDTO.class);
    }

    @Override
    public MessageDTO forwardMessage(UserDTO sender, UserDTO receiver, MessageDTO originalMessage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forwardMessage'");
    }

    @Override
    public void deleteMessage(UserDTO user, MessageDTO message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMessage'");
    }

    @Override
    public void recallMessage(UserDTO user, MessageDTO message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recallMessage'");
    }

    @Override
    public List<MessageDTO> getMessagesBetweenUsers(UserDTO user1, UserDTO user2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessagesBetweenUsers'");
    }

}
