package com.social.demo.service;

import com.social.demo.dto.MessageDTO;
import com.social.demo.entity.MessageEntity;

public interface MessageStrategy {
    MessageEntity sendMessage(MessageDTO messageDTO);
}
