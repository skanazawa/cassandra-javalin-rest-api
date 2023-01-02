package com.mercadolibre.javalin.domain.attachments.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.attachments.SaveFileService;
import com.mercadolibre.javalin.repositories.SaveFileRepository;
import com.mercadolibre.objectstorage.multipart.MultipartInput;
import java.io.InputStream;

public class DefaultSaveFileService implements SaveFileService {

  private SaveFileRepository saveFileRepository;

  @Inject
  public DefaultSaveFileService(SaveFileRepository saveFileRepository) {
    this.saveFileRepository = saveFileRepository;
  }

  @Override
  public void save(String filename, InputStream file) {

    saveFileRepository.save(new MultipartInput(filename, 26214400, file));

  }
}
