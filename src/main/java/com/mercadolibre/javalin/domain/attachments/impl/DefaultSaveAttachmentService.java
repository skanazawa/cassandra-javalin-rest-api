package com.mercadolibre.javalin.domain.attachments.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.SaveAttachmentService;
import com.mercadolibre.javalin.domain.attachments.SaveFileService;
import com.mercadolibre.javalin.domain.attachments.SaveMetadataService;
import com.mercadolibre.javalin.domain.dtos.MetadataDTO;
import io.javalin.http.UploadedFile;
import java.io.IOException;
import java.net.URLConnection;
import java.util.UUID;

public class DefaultSaveAttachmentService implements SaveAttachmentService {

  private SaveFileService saveFileService;

  private SaveMetadataService saveMetadataService;

  @Inject
  public DefaultSaveAttachmentService(SaveFileService saveFileService, SaveMetadataService saveMetadataService) {
    this.saveFileService = saveFileService;
    this.saveMetadataService = saveMetadataService;
  }

  @Override
  public String save(UploadedFile uploadedFile) {
    try {

      String mimeType = URLConnection.guessContentTypeFromStream(uploadedFile.content());

      String randomUUID = UUID.randomUUID().toString();
      String uuid = String.format("%s", randomUUID);
      String filename = String.format("%s.%s", uuid, "jpg").toLowerCase();

      saveFileService.save(filename, uploadedFile.content());

      MetadataDTO metadata = MetadataDTO.builder().originalFileName(uploadedFile.filename())
          .fileSize(uploadedFile.size()).mimeType(mimeType).build();

      saveMetadataService.save(filename, metadata);

      return filename;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
