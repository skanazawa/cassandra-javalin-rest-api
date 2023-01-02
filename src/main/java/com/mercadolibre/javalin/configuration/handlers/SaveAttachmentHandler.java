package com.mercadolibre.javalin.configuration.handlers;

import io.javalin.http.Context;

public interface SaveAttachmentHandler {
  Context save(Context ctx);
}
