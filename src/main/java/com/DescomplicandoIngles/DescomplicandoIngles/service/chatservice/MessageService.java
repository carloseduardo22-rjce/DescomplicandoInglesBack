package com.DescomplicandoIngles.DescomplicandoIngles.service.chatservice;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Group;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Message;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.GroupRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.MessageRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Message saveMessage (Integer groupId, Message message) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ObjectNotFoundException("Object group not found!"));

        message.setGroup(group);
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }

}
