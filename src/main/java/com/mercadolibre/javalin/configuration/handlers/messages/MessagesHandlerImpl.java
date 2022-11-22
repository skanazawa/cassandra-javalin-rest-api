package com.mercadolibre.javalin.configuration.handlers.messages;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.messages.MessagesService;
import com.mercadolibre.javalin.domain.dtos.Message;
import io.javalin.http.ContentType;
import io.javalin.http.Context;

public class MessagesHandlerImpl implements MessagesHandler {

  private final MessagesService messagesService;

  @Inject
  public MessagesHandlerImpl(MessagesService messagesService) {
    this.messagesService = messagesService;
  }
  @Override
  public Context getMessageById(Context ctx) {
    String messageId = ctx.pathParam("message_id");
    Message message = messagesService.getMessageById(messageId);
    return ctx.contentType(ContentType.APPLICATION_JSON).json(message);
  }
}
