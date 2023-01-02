package com.mercadolibre.javalin.configuration.inyectors;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mercadolibre.javalin.configuration.handlers.DeleteAttachmentHandler;
import com.mercadolibre.javalin.configuration.handlers.DeleteAttachmentHandlerImpl;
import com.mercadolibre.javalin.configuration.handlers.RetrieveAttachmentHandler;
import com.mercadolibre.javalin.configuration.handlers.RetrieveAttachmentHandlerImpl;
import com.mercadolibre.javalin.configuration.handlers.RetrieveMetadataHandler;
import com.mercadolibre.javalin.configuration.handlers.RetrieveMetadataHandlerImpl;
import com.mercadolibre.javalin.configuration.handlers.SaveAttachmentHandler;
import com.mercadolibre.javalin.configuration.handlers.SaveAttachmentHandlerImpl;
import com.mercadolibre.javalin.configuration.routers.DeleteAttachmentRouter;
import com.mercadolibre.javalin.configuration.routers.DeleteAttachmentRouterImpl;
import com.mercadolibre.javalin.configuration.routers.RetrieveAttachmentRouter;
import com.mercadolibre.javalin.configuration.routers.RetrieveAttachmentRouterImpl;
import com.mercadolibre.javalin.configuration.routers.RetrieveMetadataRouter;
import com.mercadolibre.javalin.configuration.routers.RetrieveMetadataRouterImpl;
import com.mercadolibre.javalin.configuration.routers.SaveAttachmentRouter;
import com.mercadolibre.javalin.configuration.routers.SaveAttachmentRouterImpl;
import com.mercadolibre.javalin.domain.attachments.DeleteAttachmentService;
import com.mercadolibre.javalin.domain.attachments.RetrieveFileService;
import com.mercadolibre.javalin.domain.attachments.RetrieveMetadataService;
import com.mercadolibre.javalin.domain.attachments.SaveAttachmentService;
import com.mercadolibre.javalin.domain.attachments.SaveFileService;
import com.mercadolibre.javalin.domain.attachments.SaveMetadataService;
import com.mercadolibre.javalin.domain.attachments.impl.DefaultDeleteAttachmentService;
import com.mercadolibre.javalin.domain.attachments.impl.DefaultRetrieveFileService;
import com.mercadolibre.javalin.domain.attachments.impl.DefaultRetrieveMetadataService;
import com.mercadolibre.javalin.domain.attachments.impl.DefaultSaveAttachmentService;
import com.mercadolibre.javalin.domain.attachments.impl.DefaultSaveFileService;
import com.mercadolibre.javalin.domain.attachments.impl.DefaultSaveMetadataService;
import com.mercadolibre.javalin.repositories.DeleteFileRepository;
import com.mercadolibre.javalin.repositories.DeleteMetadataRepository;
import com.mercadolibre.javalin.repositories.RetrieveFileRepository;
import com.mercadolibre.javalin.repositories.RetrieveMetadataRepository;
import com.mercadolibre.javalin.repositories.SaveFileRepository;
import com.mercadolibre.javalin.repositories.SaveMetadataRepository;
import com.mercadolibre.javalin.repositories.impl.DefaultFileRepository;
import com.mercadolibre.javalin.repositories.impl.DefaultMetadataRepository;
import com.mercadolibre.kvsclient.ContainerKvsLowLevelClient;
import com.mercadolibre.kvsclient.kvsapi.KvsapiConfiguration;
import com.mercadolibre.kvsclient.kvsapi.KvsapiLowLevelClient;
import com.mercadolibre.objectstorage.ObjectStorage;
import com.mercadolibre.objectstorage.ObjectStorageService;

import com.mercadolibre.rest.RestConfig;
import com.mercadolibre.restclient.RESTPool;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.http.RedirectStrategy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

public class AttachmentsModule extends AbstractModule {

  @Override
  protected void configure() {
    binder().requireExplicitBindings();
    //Repositories
    bind(RetrieveFileRepository.class).to(DefaultFileRepository.class).in(com.google.inject.Singleton.class);
    bind(RetrieveMetadataRepository.class).to(DefaultMetadataRepository.class).in(com.google.inject.Singleton.class);
    bind(SaveFileRepository.class).to(DefaultFileRepository.class).in(com.google.inject.Singleton.class);;
    bind(SaveMetadataRepository.class).to(DefaultMetadataRepository.class).in(com.google.inject.Singleton.class);
    bind(DeleteFileRepository.class).to(DefaultFileRepository.class).in(com.google.inject.Singleton.class);
    bind(DeleteMetadataRepository.class).to(DefaultMetadataRepository.class).in(com.google.inject.Singleton.class);
    //Services
    bind(RetrieveFileService.class).to(DefaultRetrieveFileService.class).in(com.google.inject.Singleton.class);
    bind(RetrieveMetadataService.class).to(DefaultRetrieveMetadataService.class).in(com.google.inject.Singleton.class);
    bind(SaveFileService.class).to(DefaultSaveFileService.class).in(com.google.inject.Singleton.class);
    bind(SaveMetadataService.class).to(DefaultSaveMetadataService.class).in(com.google.inject.Singleton.class);
    bind(SaveAttachmentService.class).to(DefaultSaveAttachmentService.class).in(com.google.inject.Singleton.class);
    bind(DeleteAttachmentService.class).to(DefaultDeleteAttachmentService.class).in(com.google.inject.Singleton.class);
    //Handlers
    bind(SaveAttachmentHandler.class).to(SaveAttachmentHandlerImpl.class).in(com.google.inject.Singleton.class);
    bind(RetrieveAttachmentHandler.class).to(RetrieveAttachmentHandlerImpl.class).in(com.google.inject.Singleton.class);
    bind(RetrieveMetadataHandler.class).to(RetrieveMetadataHandlerImpl.class).in(com.google.inject.Singleton.class);
    bind(DeleteAttachmentHandler.class).to(DeleteAttachmentHandlerImpl.class).in(com.google.inject.Singleton.class);
    //Routers
    bind(SaveAttachmentRouter.class).to(SaveAttachmentRouterImpl.class).in(com.google.inject.Singleton.class);
    bind(RetrieveAttachmentRouter.class).to(RetrieveAttachmentRouterImpl.class).in(com.google.inject.Singleton.class);
    bind(RetrieveMetadataRouter.class).to(RetrieveMetadataRouterImpl.class).in(com.google.inject.Singleton.class);
    bind(DeleteAttachmentRouter.class).to(DeleteAttachmentRouterImpl.class).in(com.google.inject.Singleton.class);
  }

  @Provides
  @Singleton
  ObjectStorage objectStorageProvider() throws IOException {
    RESTPool readPool = createRestPool("os_read_test", TimeUnit.SECONDS.toMillis(1200000000), 100);
    RESTPool writePool = createRestPool("os_write_test", TimeUnit.SECONDS.toMillis(1000000000), 100);

    RestClient restClient = RestClient.builder().withPool(readPool, writePool).build();

    RestConfig restConfig = new RestConfig(restClient, "os_read_test", "os_write_test");

    return new ObjectStorageService("SBOX8QSFXCEBCH", restConfig);
  }

  private static RESTPool createRestPool(String name, long timeout, int maxConnections) {
    return RESTPool.builder()
        .withName(name)
        .withRedirectStrategy(RedirectStrategy.ALL)
        .withConnectionTimeout(timeout)
        .withSocketTimeout(timeout)
        .withMaxPoolWait(timeout)
        .withMaxTotal(maxConnections)
        .withMaxPerRoute(maxConnections)
        .build();
  }

  @Provides
  @Singleton
  ContainerKvsLowLevelClient kvsProvider() {
    KvsapiConfiguration config = KvsapiConfiguration.builder()
        .withSocketTimeout(150) //all of this are default values
        .withMaxWait(100)
        .withConnectionTimeout(100)
        .withMaxConnections(30)
        .withMaxConnectionsPerRoute(30)
        .withMaxRetries(1)
        .withRetryDelay(30)
        .build();
    return new ContainerKvsLowLevelClient(new KvsapiLowLevelClient(config), "SBOXHRQGX4G0C7");
  }

}
