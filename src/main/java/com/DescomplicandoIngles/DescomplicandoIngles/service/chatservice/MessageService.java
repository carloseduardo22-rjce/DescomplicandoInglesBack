package com.DescomplicandoIngles.DescomplicandoIngles.service.chatservice;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Group;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Message;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.GroupRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.MessageRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final GroupRepository groupRepository;

    public MessageService(MessageRepository messageRepository, GroupRepository groupRepository) {
        this.messageRepository = messageRepository;
        this.groupRepository = groupRepository;
    }

    public Message saveMessage (Integer groupId, Message message) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new EntityNotFoundException("Group not found with id: " + groupId));

        message.setGroup(group);
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }

}
