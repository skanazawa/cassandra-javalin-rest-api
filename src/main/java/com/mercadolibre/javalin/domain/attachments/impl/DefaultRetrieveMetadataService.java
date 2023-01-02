package com.mercadolibre.javalin.domain.attachments.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.RetrieveMetadataService;
import com.mercadolibre.javalin.domain.dtos.MetadataDTO;
import com.mercadolibre.javalin.repositories.RetrieveMetadataRepository;

public class DefaultRetrieveMetadataService implements RetrieveMetadataService {

  private RetrieveMetadataRepository retrieveMetadataRepository;

  @Inject
  public DefaultRetrieveMetadataService(RetrieveMetadataRepository retrieveMetadataRepository) {
    this.retrieveMetadataRepository = retrieveMetadataRepository;
  }

  @Override
  public MetadataDTO retrieve(String filename) {
    return retrieveMetadataRepository.retrieve(filename);
  }
}
