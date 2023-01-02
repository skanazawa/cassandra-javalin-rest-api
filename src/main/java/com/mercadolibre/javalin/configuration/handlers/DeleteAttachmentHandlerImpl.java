package com.mercadolibre.javalin.configuration.handlers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.DeleteAttachmentService;
import io.javalin.http.Context;

public class DeleteAttachmentHandlerImpl implements DeleteAttachmentHandler {

  private DeleteAttachmentService deleteAttachmentService;

  @Inject
  public DeleteAttachmentHandlerImpl(DeleteAttachmentService deleteAttachmentService) {
    this.deleteAttachmentService = deleteAttachmentService;
  }

  @Override
  public void delete(Context ctx) {
    String filename = ctx.pathParam("filename");
    deleteAttachmentService.delete(filename);
  }
}
