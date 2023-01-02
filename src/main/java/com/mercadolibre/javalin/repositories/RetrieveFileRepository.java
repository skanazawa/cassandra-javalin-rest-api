package com.mercadolibre.javalin.repositories;

public interface RetrieveFileRepository {

  byte[] retrieve(String filename);

}
