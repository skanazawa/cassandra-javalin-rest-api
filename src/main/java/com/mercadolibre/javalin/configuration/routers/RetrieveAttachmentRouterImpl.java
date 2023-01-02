package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.RetrieveAttachmentHandler;
import io.javalin.Javalin;

public class RetrieveAttachmentRouterImpl implements RetrieveAttachmentRouter {

  private final Javalin javalin;

  private final RetrieveAttachmentHandler retrieveAttachmentHandler;

  @Inject
  public RetrieveAttachmentRouterImpl(Javalin javalin, RetrieveAttachmentHandler retrieveAttachmentHandler) {
    this.javalin = javalin;
    this.retrieveAttachmentHandler = retrieveAttachmentHandler;
  }

  @Override
  public void bind() {
    javalin.get("/api/attachment/{filename}", retrieveAttachmentHandler::get);
  }
}
