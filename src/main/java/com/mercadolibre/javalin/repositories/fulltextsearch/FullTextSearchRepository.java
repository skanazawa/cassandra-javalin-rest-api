package com.mercadolibre.javalin.repositories.fulltextsearch;

import com.mercadolibre.javalin.domain.dtos.FullTextSearch;

public interface FullTextSearchRepository {
  Long fullTextSearch(FullTextSearch fts);
}
