package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.messages.MessagesHandler;
import io.javalin.Javalin;

public class MessagesRouterImpl implements MessagesRouter {

  private final Javalin javalin;
  private final MessagesHandler messagesHandler;

  @Inject
  public MessagesRouterImpl(Javalin javalin, MessagesHandler messagesHandler) {
    this.javalin = javalin;
    this.messagesHandler = messagesHandler;
  }

  @Override
  public void bind() {
    javalin.get("/api/messages/{message_id}", messagesHandler::getMessageById);
  }
}
