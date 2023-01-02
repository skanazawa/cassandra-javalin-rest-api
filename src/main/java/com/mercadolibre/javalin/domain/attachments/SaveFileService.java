package com.mercadolibre.javalin.domain.attachments;

import java.io.InputStream;

public interface SaveFileService {

  void save(String filename, InputStream file);

}
