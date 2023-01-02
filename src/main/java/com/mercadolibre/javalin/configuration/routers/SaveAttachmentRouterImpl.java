package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.SaveAttachmentHandler;
import io.javalin.Javalin;

public class SaveAttachmentRouterImpl implements SaveAttachmentRouter {

  private final Javalin javalin;

  private final SaveAttachmentHandler saveAttachmentHandler;

  @Inject
  public SaveAttachmentRouterImpl(Javalin javalin, SaveAttachmentHandler saveAttachmentHandler) {
    this.javalin = javalin;
    this.saveAttachmentHandler = saveAttachmentHandler;
  }

  @Override
  public void bind() {
    javalin.post("/api/attachment", saveAttachmentHandler::save);
  }
}
