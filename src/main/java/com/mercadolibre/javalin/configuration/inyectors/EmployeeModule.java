package com.mercadolibre.javalin.configuration.inyectors;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.mercadolibre.javalin.configuration.routers.EmployeeRouterImpl;
import com.mercadolibre.javalin.configuration.routers.EmployeeRouter;
import com.mercadolibre.javalin.configuration.handlers.findemployees.EmployeeRequestHandler;
import com.mercadolibre.javalin.configuration.handlers.findemployees.EmployeeRequestHandlerImpl;
import com.mercadolibre.javalin.domain.employees.EmployeeService;
import com.mercadolibre.javalin.domain.employees.impl.EmployeeServiceImpl;
import com.mercadolibre.javalin.repositories.employees.CassandraEmployeeRepository;
import com.mercadolibre.javalin.repositories.employees.EmployeeRepository;

public class EmployeeModule extends AbstractModule {

  @Override
  protected void configure() {
    binder().requireExplicitBindings();
    bind(EmployeeRouter.class).to(EmployeeRouterImpl.class).in(Singleton.class);
    bind(EmployeeRepository.class).to(CassandraEmployeeRepository.class).in(Singleton.class);
    bind(EmployeeService.class).to(EmployeeServiceImpl.class).in(Singleton.class);
    bind(EmployeeRequestHandler.class).to(EmployeeRequestHandlerImpl.class).in(Singleton.class);
  }
}
