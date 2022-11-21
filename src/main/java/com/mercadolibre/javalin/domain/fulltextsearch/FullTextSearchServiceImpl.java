package com.mercadolibre.javalin.domain.fulltextsearch;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.FullTextSearch;
import com.mercadolibre.javalin.repositories.fulltextsearch.FullTextSearchRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FullTextSearchServiceImpl implements FullTextSearchService {

  private final FullTextSearchRepository fullTextSearchServiceRepository;

  @Inject
  public FullTextSearchServiceImpl(FullTextSearchRepository fullTextSearchServiceRepository) {
    this.fullTextSearchServiceRepository = fullTextSearchServiceRepository;
  }

  @Override
  public Long fullTextSearch(FullTextSearch fts) {
    return fullTextSearchServiceRepository.fullTextSearch(fts);
  }
}
