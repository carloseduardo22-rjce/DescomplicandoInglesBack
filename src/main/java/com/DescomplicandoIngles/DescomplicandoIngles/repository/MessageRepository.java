package com.DescomplicandoIngles.DescomplicandoIngles.repository;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
