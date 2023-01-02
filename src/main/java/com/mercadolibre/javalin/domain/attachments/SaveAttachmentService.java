package com.mercadolibre.javalin.domain.attachments;

import io.javalin.http.UploadedFile;

public interface SaveAttachmentService {
  String save(UploadedFile uploadedFile);
}
