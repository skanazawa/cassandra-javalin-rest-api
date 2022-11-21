package com.mercadolibre.javalin.configuration.routers;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.handlers.findemployees.EmployeeRequestHandler;
import io.javalin.Javalin;

public class EmployeeRouterImpl implements EmployeeRouter {
  private final Javalin javalin;
  private final EmployeeRequestHandler employeeRequestHandler;

  @Inject
  public EmployeeRouterImpl(Javalin javalin, EmployeeRequestHandler employeeRequestHandler) {
    this.javalin = javalin;
    this.employeeRequestHandler = employeeRequestHandler;
  }

  @Override
  public void bind() {
    javalin.get("/api/messages", employeeRequestHandler::get);
  }
}
