package com.social.demo.service.strategy;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.demo.constants.Constants;
import com.social.demo.constants.MessageStatus;
import com.social.demo.dto.MessageDTO;
import com.social.demo.entity.FileMessageEntity;
import com.social.demo.entity.MessageEntity;
import com.social.demo.entity.UserEntity;
import com.social.demo.repository.FileMessageRepository;
import com.social.demo.repository.UserRepository;
import com.social.demo.service.IFileService;
import com.social.demo.service.MessageStrategy;

@Service
public class FileMessageStrategy implements MessageStrategy {
    @Autowired
    private FileMessageRepository fileMessageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IFileService fileService;

    @Override
    public MessageEntity sendMessage(MessageDTO messageDTO) {

        FileMessageEntity fileMessageEntity = modelMapper.map(messageDTO, FileMessageEntity.class);
        try {
            String uploadDir = Constants.MESSAGE_DIRECTORY + messageDTO.getMessageType();
            String fileName = fileService.saveFileUpload(uploadDir, messageDTO.getFile());

            // Cập nhật thông tin file trong đối tượng FileMessageEntity
            fileMessageEntity.setFileName(fileName);
            fileMessageEntity.setSize(messageDTO.getFile().getSize());
            fileMessageEntity.setStatus(MessageStatus.NORMAL);
            return fileMessageRepository.save(fileMessageEntity);
        } catch (IOException e) {
            // Xử lý exception nếu có lỗi khi lưu file
            e.printStackTrace();
            return null;
        }
    }
}