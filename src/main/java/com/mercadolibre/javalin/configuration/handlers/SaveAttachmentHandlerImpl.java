package com.mercadolibre.javalin.configuration.handlers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.SaveAttachmentService;
import com.mercadolibre.javalin.domain.dtos.FileDataDTO;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.UploadedFile;

public class SaveAttachmentHandlerImpl implements SaveAttachmentHandler {

  private final SaveAttachmentService saveAttachmentService;

  @Inject
  public SaveAttachmentHandlerImpl(SaveAttachmentService saveAttachmentService) {
    this.saveAttachmentService = saveAttachmentService;
  }

  @Override
  public Context save(Context ctx) {
    UploadedFile uploadedFile = ctx.uploadedFile("file");
    FileDataDTO fileDataDTO = FileDataDTO.builder().id(saveAttachmentService.save(uploadedFile)).build();
    return ctx.contentType(ContentType.APPLICATION_JSON).json(fileDataDTO);
  }
}
