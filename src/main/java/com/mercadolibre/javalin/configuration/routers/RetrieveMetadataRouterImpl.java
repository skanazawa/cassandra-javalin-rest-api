package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.RetrieveMetadataHandler;
import io.javalin.Javalin;

public class RetrieveMetadataRouterImpl implements RetrieveMetadataRouter {

  private final Javalin javalin;

  private final RetrieveMetadataHandler retrieveMetadataHandler;

  @Inject
  public RetrieveMetadataRouterImpl(Javalin javalin, RetrieveMetadataHandler retrieveMetadataHandler) {
    this.retrieveMetadataHandler = retrieveMetadataHandler;
    this.javalin = javalin;
  }

  @Override
  public void bind() {
    javalin.get("/api/attachment/{filename}/metadata", retrieveMetadataHandler::retrieveMetadata);
  }
}
