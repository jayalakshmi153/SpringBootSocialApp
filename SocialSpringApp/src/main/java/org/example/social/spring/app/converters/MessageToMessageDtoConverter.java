package org.example.social.spring.app.converters;

import org.example.social.spring.app.dto.MessageDTO;
import org.example.social.spring.app.entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageToMessageDtoConverter {

    private final UserToUserDtoConverter userToUserDtoConverter;

    public MessageDTO convert(Message message, Long id) {
        if(message == null) {
            return null;
        }
        return MessageDTO.builder()
                         .time(message.getTime())
                         .message(message.getMessage())
                         .receiver(userToUserDtoConverter.convert(message.getReceiver()))
                         .sender(userToUserDtoConverter.convert(message.getSender()))
                         .companionId(id.equals(message.getSender().getId()) ?
                                      message.getReceiver().getId() : message.getSender().getId())
                         .build();
    }
}
