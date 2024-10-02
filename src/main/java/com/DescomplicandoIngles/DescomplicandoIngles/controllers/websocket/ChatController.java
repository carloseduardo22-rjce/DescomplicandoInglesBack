package com.DescomplicandoIngles.DescomplicandoIngles.controllers.websocket;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Message;
import com.DescomplicandoIngles.DescomplicandoIngles.service.chatservice.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    // Indica que este método deve ser invocado quando uma mensagem é recebida no endpoint
    // /descomplicaingles/{groupId}/send
    @MessageMapping("/{groupId}/send")
    // Define que a resposta do método deve ser enviada para todos os
    // clientes que estão inscritos no tópico /topic/group/{groupId}
    @SendTo("/topic/group/{groupId}")
    public Message sendMessage(@DestinationVariable Integer groupId, Message message) {
        return messageService.saveMessage(groupId, message);
    }

}
