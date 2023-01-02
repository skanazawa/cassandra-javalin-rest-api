package com.mercadolibre.javalin.domain.attachments.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.SaveMetadataService;
import com.mercadolibre.javalin.domain.dtos.MetadataDTO;
import com.mercadolibre.javalin.repositories.SaveMetadataRepository;

public class DefaultSaveMetadataService implements SaveMetadataService {

  private SaveMetadataRepository saveMetadataRepository;

  @Inject
  public DefaultSaveMetadataService(SaveMetadataRepository saveMetadataRepository) {
    this.saveMetadataRepository = saveMetadataRepository;
  }

  @Override
  public void save(String filename, MetadataDTO metadataDTO) {
    saveMetadataRepository.save(filename, metadataDTO);
  }
}
