package com.mercadolibre.javalin.domain.messages;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.Message;
import com.mercadolibre.javalin.repositories.messages.MessagesRepository;

public class MessagesServicesImpl implements  MessagesService {

  private final MessagesRepository messagesRepository;

  @Inject
  public MessagesServicesImpl(MessagesRepository messagesRepository) {
     this.messagesRepository=messagesRepository;
  }

  @Override
  public Message getMessageById(String messageId) {
    return messagesRepository.getMessageById(messageId);
  }
}
