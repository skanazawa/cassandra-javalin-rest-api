package com.mercadolibre.javalin.repositories.impl;

import com.google.gson.Gson;
import com.mercadolibre.javalin.domain.dtos.MetadataDTO;
import com.mercadolibre.javalin.repositories.DeleteMetadataRepository;
import com.mercadolibre.javalin.repositories.SaveMetadataRepository;
import com.mercadolibre.javalin.repositories.RetrieveMetadataRepository;
import com.mercadolibre.kvsclient.ContainerKvsLowLevelClient;
import com.mercadolibre.kvsclient.exceptions.KvsException;
import com.mercadolibre.kvsclient.item.Item;
import javax.inject.Inject;

public class DefaultMetadataRepository implements RetrieveMetadataRepository, SaveMetadataRepository, DeleteMetadataRepository {

  ContainerKvsLowLevelClient kvs;

  @Inject
  public DefaultMetadataRepository(ContainerKvsLowLevelClient kvs) {
    this.kvs = kvs;
  }

  @Override
  public MetadataDTO retrieve(String filename) {
    try {
      Item item = kvs.get(filename);
      return new Gson().fromJson(item.getValueAsString(), MetadataDTO.class);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void save(String filename, MetadataDTO metadata) {
    Item item = new Item(filename, metadata);
    try {
      kvs.save(item);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(String filename) {
    try {
      kvs.delete(filename);
    } catch (KvsException e) {
      throw new RuntimeException(e);
    }
  }
}
