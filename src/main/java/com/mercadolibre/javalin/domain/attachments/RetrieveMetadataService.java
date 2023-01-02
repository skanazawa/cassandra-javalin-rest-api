package com.mercadolibre.javalin.domain.attachments;

import com.mercadolibre.javalin.domain.dtos.MetadataDTO;

public interface RetrieveMetadataService {

  MetadataDTO retrieve(String filename);

}
