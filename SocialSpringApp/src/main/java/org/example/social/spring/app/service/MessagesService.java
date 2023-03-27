package org.example.social.spring.app.service;

import org.example.social.spring.app.dto.MessageDTO;

import java.util.Collection;
import java.util.List;

public interface MessagesService {
    Collection<MessageDTO> findAllRecentMessages(Long id);

    List<MessageDTO> findConversation(Long userId, Long companionId);

    MessageDTO getRecentMessage(Long id);

    void postMessage(MessageDTO messageDTO);
}
