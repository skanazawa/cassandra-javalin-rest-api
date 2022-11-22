package com.mercadolibre.javalin.repositories.messages;

import com.mercadolibre.javalin.domain.dtos.Message;

public interface MessagesRepository {
  Message getMessageById(String messageId);
}
