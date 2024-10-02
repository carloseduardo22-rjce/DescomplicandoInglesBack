package com.DescomplicandoIngles.DescomplicandoIngles.controllers.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints (StompEndpointRegistry registry) {
        // Define um endpoint no caminho /chat para que os clientes possam se conectar
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker (MessageBrokerRegistry config) {
        // Habilita um broker simples que permite a publicação e assinatura
        // de mensagens em tópicos que começam com /topic
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/descomplicandoingles");
    }

}
