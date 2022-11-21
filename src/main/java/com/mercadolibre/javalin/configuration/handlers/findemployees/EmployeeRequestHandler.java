package com.mercadolibre.javalin.configuration.handlers.findemployees;

import io.javalin.http.Context;

public interface EmployeeRequestHandler {
  public Context get(Context ctx);
}
