package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.fulltextsearch.FullTextSearchHandler;
import io.javalin.Javalin;

public class FullTextSearchRouterImpl implements FullTextSearchRouter {
  private final Javalin javalin;
  private final FullTextSearchHandler fullTextSearchHandler;

  @Inject
  public FullTextSearchRouterImpl(Javalin javalin, FullTextSearchHandler fullTextSearchHandler) {
    this.javalin = javalin;
    this.fullTextSearchHandler = fullTextSearchHandler;
  }

  @Override
  public void bind() {
    javalin.post("/api/search", fullTextSearchHandler::post);
  }
}
