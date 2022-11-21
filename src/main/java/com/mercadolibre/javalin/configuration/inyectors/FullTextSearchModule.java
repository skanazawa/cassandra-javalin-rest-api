package com.mercadolibre.javalin.configuration.inyectors;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.mercadolibre.javalin.configuration.routers.FullTextSearchRouter;
import com.mercadolibre.javalin.configuration.routers.FullTextSearchRouterImpl;
import com.mercadolibre.javalin.configuration.handlers.fulltextsearch.FullTextSearchHandler;
import com.mercadolibre.javalin.configuration.handlers.fulltextsearch.FullTextSearchHandlerImpl;
import com.mercadolibre.javalin.domain.fulltextsearch.FullTextSearchService;
import com.mercadolibre.javalin.domain.fulltextsearch.FullTextSearchServiceImpl;
import com.mercadolibre.javalin.repositories.fulltextsearch.FullTextSearchRepository;
import com.mercadolibre.javalin.repositories.fulltextsearch.FullTextSearchRepositoryImpl;

public class FullTextSearchModule extends AbstractModule {

  @Override
  protected void configure() {
    binder().requireExplicitBindings();
    bind(FullTextSearchRouter.class).to(FullTextSearchRouterImpl.class).in(Singleton.class);
    bind(FullTextSearchRepository.class).to(FullTextSearchRepositoryImpl.class).in(Singleton.class);
    bind(FullTextSearchService.class).to(FullTextSearchServiceImpl.class).in(Singleton.class);
    bind(FullTextSearchHandler.class).to(FullTextSearchHandlerImpl.class).in(Singleton.class);
  }
}
