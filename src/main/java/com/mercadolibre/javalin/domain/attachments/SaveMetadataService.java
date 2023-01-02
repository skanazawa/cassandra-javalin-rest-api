package com.mercadolibre.javalin.domain.attachments;

import com.mercadolibre.javalin.domain.dtos.MetadataDTO;

public interface SaveMetadataService {

  void save(String filename, MetadataDTO metadataDTO);

}
