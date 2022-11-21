package com.mercadolibre.javalin.configuration.handlers.fulltextsearch;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.FullTextSearch;
import com.mercadolibre.javalin.domain.dtos.SearchTextResponse;
import com.mercadolibre.javalin.domain.fulltextsearch.FullTextSearchService;
import io.javalin.http.ContentType;
import io.javalin.http.Context;

public class FullTextSearchHandlerImpl implements FullTextSearchHandler {

  private final FullTextSearchService fullTextSearchService;

  @Inject
  public FullTextSearchHandlerImpl(FullTextSearchService fullTextSearchService) {
    this.fullTextSearchService = fullTextSearchService;
  }

  @Override
  public Context post(Context ctx) {
    FullTextSearch fts = ctx.bodyAsClass(FullTextSearch.class);
    long quantity = fullTextSearchService.fullTextSearch(fts);
    SearchTextResponse searchTextResponse = SearchTextResponse.builder().quantity(quantity).build();
    return ctx.contentType(ContentType.APPLICATION_JSON).json(searchTextResponse);
  }
}
