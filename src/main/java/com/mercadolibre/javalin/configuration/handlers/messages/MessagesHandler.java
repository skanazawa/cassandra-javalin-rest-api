package com.mercadolibre.javalin.configuration.handlers.messages;

import io.javalin.http.Context;

public interface MessagesHandler {
  Context getMessageById(Context context);
}
