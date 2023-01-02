package com.mercadolibre.javalin.repositories;

import com.mercadolibre.objectstorage.multipart.MultipartInput;

public interface SaveFileRepository {
  void save(MultipartInput file);
}
