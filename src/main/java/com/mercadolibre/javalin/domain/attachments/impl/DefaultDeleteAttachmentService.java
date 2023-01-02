package com.mercadolibre.javalin.domain.attachments.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.DeleteAttachmentService;
import com.mercadolibre.javalin.repositories.DeleteFileRepository;
import com.mercadolibre.javalin.repositories.DeleteMetadataRepository;

public class DefaultDeleteAttachmentService implements DeleteAttachmentService {

  private DeleteFileRepository deleteFileRepository;

  private DeleteMetadataRepository deleteMetadataRepository;

  @Inject
  public DefaultDeleteAttachmentService(DeleteFileRepository deleteFileRepository, DeleteMetadataRepository deleteMetadataRepository) {
    this.deleteFileRepository = deleteFileRepository;
    this.deleteMetadataRepository = deleteMetadataRepository;
  }

  @Override
  public void delete(String filename) {
    deleteFileRepository.delete(filename);
    deleteMetadataRepository.delete(filename);
  }
}
