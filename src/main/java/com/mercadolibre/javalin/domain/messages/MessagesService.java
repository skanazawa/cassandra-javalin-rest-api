package com.mercadolibre.javalin.domain.messages;

import com.mercadolibre.javalin.domain.dtos.Message;

public interface MessagesService {
  Message getMessageById(String messageId);

}
