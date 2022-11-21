package com.mercadolibre.javalin.configuration.inyectors;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mercadolibre.javalin.configuration.ApplicationStarter;
import java.net.InetSocketAddress;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        binder().requireExplicitBindings();

        install(new JavalinModule());
        install(new EmployeeModule());
        install(new FullTextSearchModule());

        bind(ApplicationStarter.class).in(Singleton.class);
    }


    @Provides
    static CqlSession provideCassandraCqlSession() {
        CqlSessionBuilder sessionBuilder = CqlSession.builder().addContactPoint(new InetSocketAddress("127.0.0.1", 9042));
        sessionBuilder.withKeyspace("messaging");
        sessionBuilder.withLocalDatacenter("datacenter1");
        return sessionBuilder.build();
    }
}
