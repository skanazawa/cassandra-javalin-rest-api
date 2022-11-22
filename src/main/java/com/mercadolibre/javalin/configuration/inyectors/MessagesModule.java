package com.mercadolibre.javalin.configuration.inyectors;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.mercadolibre.javalin.configuration.handlers.messages.MessagesHandler;
import com.mercadolibre.javalin.configuration.handlers.messages.MessagesHandlerImpl;
import com.mercadolibre.javalin.configuration.routers.MessagesRouter;
import com.mercadolibre.javalin.configuration.routers.MessagesRouterImpl;
import com.mercadolibre.javalin.domain.messages.MessagesService;
import com.mercadolibre.javalin.domain.messages.MessagesServicesImpl;
import com.mercadolibre.javalin.repositories.messages.MessagesRepository;
import com.mercadolibre.javalin.repositories.messages.MessagesRepositoryImpl;

public class MessagesModule extends AbstractModule {

  @Override
  protected void configure() {
    binder().requireExplicitBindings();
    bind(MessagesRouter.class).to(MessagesRouterImpl.class).in(Singleton.class);
    bind(MessagesRepository.class).to(MessagesRepositoryImpl.class).in(Singleton.class);
    bind(MessagesService.class).to(MessagesServicesImpl.class).in(Singleton.class);
    bind(MessagesHandler.class).to(MessagesHandlerImpl.class).in(Singleton.class);
  }
}
