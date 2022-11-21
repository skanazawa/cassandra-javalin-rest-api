package com.mercadolibre.javalin.configuration;

import static com.google.inject.Guice.createInjector;

import com.mercadolibre.javalin.configuration.inyectors.ApplicationModule;

public class Application {

  public static void main(String[] args) {
    createInjector(new ApplicationModule()).getInstance(ApplicationStarter.class).run(args);
  }
}