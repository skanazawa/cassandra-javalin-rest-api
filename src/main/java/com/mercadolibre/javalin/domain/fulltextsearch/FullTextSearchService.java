package com.mercadolibre.javalin.domain.fulltextsearch;

import com.mercadolibre.javalin.domain.dtos.FullTextSearch;

public interface FullTextSearchService {
  Long fullTextSearch(FullTextSearch fts);
}
