package com.mercadolibre.javalin.repositories;

import com.mercadolibre.javalin.domain.dtos.MetadataDTO;

public interface RetrieveMetadataRepository {

  MetadataDTO retrieve(String filename);

}
