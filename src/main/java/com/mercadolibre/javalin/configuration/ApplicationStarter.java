package com.mercadolibre.javalin.configuration;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.routers.EmployeeRouter;
import com.mercadolibre.javalin.configuration.routers.FullTextSearchRouter;
import io.javalin.Javalin;

public class ApplicationStarter {

  private final Javalin javalin;
  private final EmployeeRouter employeeRouter;
  private final FullTextSearchRouter fullTextSearchRouter;

  @Inject
  public ApplicationStarter(Javalin javalin, EmployeeRouter employeeRouter, FullTextSearchRouter fullTextSearchRouter) {
    this.javalin = javalin;
    this.employeeRouter = employeeRouter;
    this.fullTextSearchRouter = fullTextSearchRouter;
  }

  public void run(String... args) {
    employeeRouter.bind();
    fullTextSearchRouter.bind();
    javalin.start(7070);
  }
}
