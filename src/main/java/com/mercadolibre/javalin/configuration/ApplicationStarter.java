package com.mercadolibre.javalin.configuration;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.routers.EmployeeRouter;
import com.mercadolibre.javalin.configuration.routers.FullTextSearchRouter;
import com.mercadolibre.javalin.configuration.routers.MessagesRouter;
import io.javalin.Javalin;

public class ApplicationStarter {

  private final Javalin javalin;
  private final EmployeeRouter employeeRouter;
  private final FullTextSearchRouter fullTextSearchRouter;
  private final MessagesRouter messagesRouter;

  @Inject
  public ApplicationStarter(Javalin javalin,
                            EmployeeRouter employeeRouter,
                            FullTextSearchRouter fullTextSearchRouter,
                            MessagesRouter messagesRouter) {
    this.javalin = javalin;
    this.employeeRouter = employeeRouter;
    this.fullTextSearchRouter = fullTextSearchRouter;
    this.messagesRouter = messagesRouter;
  }

  public void run(String... args) {
    employeeRouter.bind();
    fullTextSearchRouter.bind();
    messagesRouter.bind();
    javalin.start(8088);
  }
}
