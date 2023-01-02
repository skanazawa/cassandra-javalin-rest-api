package com.mercadolibre.javalin.repositories.impl;

import com.mercadolibre.javalin.repositories.DeleteFileRepository;
import com.mercadolibre.javalin.repositories.SaveFileRepository;
import com.mercadolibre.javalin.repositories.RetrieveFileRepository;
import com.mercadolibre.objectstorage.ObjectStorage;
import com.mercadolibre.objectstorage.ObjectStorageException;
import com.mercadolibre.objectstorage.multipart.MultipartInput;
import javax.inject.Inject;

public class DefaultFileRepository implements RetrieveFileRepository, SaveFileRepository, DeleteFileRepository {

  private ObjectStorage client;

  @Inject
  public DefaultFileRepository(ObjectStorage client) {
    this.client = client;
  }

  @Override
  public byte[] retrieve(String filename) {
    byte[] result;

    try {
      result = client.get(filename);

    } catch (ObjectStorageException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

  @Override
  public void save(MultipartInput file) {
    try {
      client.multipart(file);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(String filename) {
    try {
      client.delete(filename);
    } catch (ObjectStorageException e) {
      throw new RuntimeException(e);
    }
  }
}
