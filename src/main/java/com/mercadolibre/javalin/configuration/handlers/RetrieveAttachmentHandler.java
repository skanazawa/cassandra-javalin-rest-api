package com.mercadolibre.javalin.configuration.handlers;

import io.javalin.http.Context;

public interface RetrieveAttachmentHandler {
  Context get(Context ctx);
}
