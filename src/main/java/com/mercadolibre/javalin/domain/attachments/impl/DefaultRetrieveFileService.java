package com.mercadolibre.javalin.domain.attachments.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.RetrieveFileService;
import com.mercadolibre.javalin.domain.dtos.AttachmentDTO;
import com.mercadolibre.javalin.repositories.RetrieveFileRepository;
import io.javalin.http.BadRequestResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Objects;

public class DefaultRetrieveFileService implements RetrieveFileService {

  private RetrieveFileRepository retrieveAttachmentRepository;

  @Inject
  public DefaultRetrieveFileService(RetrieveFileRepository retrieveAttachmentRepository) {
    this.retrieveAttachmentRepository = retrieveAttachmentRepository;
  }

  @Override
  public AttachmentDTO retrieve(String filename) {
    byte[] bytes = retrieveAttachmentRepository.retrieve(filename);
    if (Objects.isNull(bytes)) {
      throw new BadRequestResponse("File not Exist");
    }
    InputStream inputStream = new ByteArrayInputStream(bytes);
    try {
      String mimeType = URLConnection.guessContentTypeFromStream(inputStream);
      return AttachmentDTO.builder().mimeType(mimeType).file(bytes).build();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
