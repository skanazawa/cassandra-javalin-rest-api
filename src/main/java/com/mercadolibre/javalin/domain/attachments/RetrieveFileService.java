package com.mercadolibre.javalin.domain.attachments;


import com.mercadolibre.javalin.domain.dtos.AttachmentDTO;

public interface RetrieveFileService {
  AttachmentDTO retrieve(String filename);

}
