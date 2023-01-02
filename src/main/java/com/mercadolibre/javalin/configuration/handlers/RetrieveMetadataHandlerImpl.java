package com.mercadolibre.javalin.configuration.handlers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.RetrieveMetadataService;
import com.mercadolibre.javalin.domain.dtos.MetadataDTO;
import io.javalin.http.Context;
import org.apache.http.entity.mime.MIME;

public class RetrieveMetadataHandlerImpl implements RetrieveMetadataHandler {

  private RetrieveMetadataService retrieveMetadataService;

  @Inject
  public RetrieveMetadataHandlerImpl(RetrieveMetadataService retrieveMetadataService) {
    this.retrieveMetadataService = retrieveMetadataService;
  }

  @Override
  public Context retrieveMetadata(Context ctx) {
    String filename = ctx.pathParam("filename");
    MetadataDTO metadataDTO = retrieveMetadataService.retrieve(filename);
    return ctx.header(MIME.CONTENT_TYPE, "application/json").json(metadataDTO);
  }
}
