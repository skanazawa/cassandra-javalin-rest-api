package com.mercadolibre.javalin.configuration.handlers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.RetrieveFileService;
import com.mercadolibre.javalin.domain.dtos.AttachmentDTO;
import io.javalin.http.Context;
import java.nio.charset.StandardCharsets;
import org.apache.http.entity.mime.MIME;

public class RetrieveAttachmentHandlerImpl implements RetrieveAttachmentHandler {

  private final RetrieveFileService retrieveFileService;

  @Inject
  public RetrieveAttachmentHandlerImpl(RetrieveFileService retrieveFileService) {
    this.retrieveFileService = retrieveFileService;
  }

  @Override
  public Context get(Context ctx) {
    String filename = ctx.pathParam("filename");
    AttachmentDTO file = retrieveFileService.retrieve(filename);

    return ctx.header(MIME.CONTENT_TYPE, String.valueOf(file.getFile().length))
        .contentType(String.format("%s; charset=%s", file.getMimeType(), StandardCharsets.UTF_8))
        .result(file.getFile());
  }
}
