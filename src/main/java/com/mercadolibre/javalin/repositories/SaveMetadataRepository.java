package com.mercadolibre.javalin.repositories;

import com.mercadolibre.javalin.domain.dtos.MetadataDTO;

public interface SaveMetadataRepository {

  void save(String filename, MetadataDTO metadataDTO);

}
