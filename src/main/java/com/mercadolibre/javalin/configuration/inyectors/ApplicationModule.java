package com.mercadolibre.javalin.configuration.inyectors;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.mercadolibre.javalin.configuration.ApplicationStarter;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        binder().requireExplicitBindings();

        install(new JavalinModule());

        install(new AttachmentsModule());

        bind(ApplicationStarter.class).in(Singleton.class);
    }

}
