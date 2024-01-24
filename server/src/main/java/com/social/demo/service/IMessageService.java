package com.social.demo.service;

import java.util.List;

import com.social.demo.dto.MessageDTO;
import com.social.demo.dto.UserDTO;

public interface IMessageService {

    MessageDTO sendMessage(MessageDTO messageDTO);

    MessageDTO forwardMessage(UserDTO sender, UserDTO receiver, MessageDTO originalMessage);

    /**
     * Người dùng thêm biểu cảm vào tin nhắn.
     *
     * @param user    Người dùng thêm biểu cảm.
     * @param message Tin nhắn được thêm biểu cảm.
     * @param emoji   Biểu cảm được thêm vào tin nhắn.
     */
    // void addEmojiToMessage(UserEntity user, MessageDTO message, String emoji);

    /**
     * Người dùng xóa tin nhắn.
     *
     * @param user    Người dùng thực hiện xóa tin nhắn.
     * @param message Tin nhắn cần bị xóa.
     */
    void deleteMessage(UserDTO user, MessageDTO message);

    /**
     * Người dùng thu hồi tin nhắn.
     *
     * @param user    Người dùng thực hiện thu hồi tin nhắn.
     * @param message Tin nhắn cần được thu hồi.
     */
    void recallMessage(UserDTO user, MessageDTO message);

    /**
     * Lấy danh sách tin nhắn giữa hai người dùng.
     *
     * @param user1 Người dùng thứ nhất.
     * @param user2 Người dùng thứ hai.
     * @return Danh sách các đối tượng tin nhắn giữa hai người dùng.
     */
    List<MessageDTO> getMessagesBetweenUsers(UserDTO user1, UserDTO user2);
}
