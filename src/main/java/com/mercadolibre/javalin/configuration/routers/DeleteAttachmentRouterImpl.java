package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.DeleteAttachmentHandler;
import io.javalin.Javalin;

public class DeleteAttachmentRouterImpl implements DeleteAttachmentRouter {

  private final Javalin javalin;

  private final DeleteAttachmentHandler deleteAttachmentHandler;

  @Inject
  public DeleteAttachmentRouterImpl(DeleteAttachmentHandler deleteAttachmentHandler, Javalin javalin) {
    this.deleteAttachmentHandler = deleteAttachmentHandler;
    this.javalin = javalin;
  }

  @Override
  public void bind() {
    javalin.delete("/api/attachment/{filename}", deleteAttachmentHandler::delete);
  }
}
