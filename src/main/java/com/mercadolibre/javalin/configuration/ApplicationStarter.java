package com.mercadolibre.javalin.configuration;

import com.google.inject.Inject;
import com.mercadolibre.javalin.configuration.routers.DeleteAttachmentRouter;
import com.mercadolibre.javalin.configuration.routers.RetrieveAttachmentRouter;
import com.mercadolibre.javalin.configuration.routers.RetrieveMetadataRouter;
import com.mercadolibre.javalin.configuration.routers.SaveAttachmentRouter;
import io.javalin.Javalin;

public class ApplicationStarter {

  private final Javalin javalin;

  private final SaveAttachmentRouter saveAttachmentRouter;

  private final RetrieveAttachmentRouter retrieveAttachmentRouter;

  private final DeleteAttachmentRouter deleteAttachmentRouter;

  private final RetrieveMetadataRouter retrieveMetadataRouter;

  @Inject
  public ApplicationStarter(Javalin javalin,
                            SaveAttachmentRouter saveAttachmentRouter,
                            RetrieveAttachmentRouter retrieveAttachmentRouter,
                            DeleteAttachmentRouter deleteAttachmentRouter,
                            RetrieveMetadataRouter retrieveMetadataRouter) {
    this.javalin = javalin;
    this.saveAttachmentRouter = saveAttachmentRouter;
    this.retrieveAttachmentRouter = retrieveAttachmentRouter;
    this.deleteAttachmentRouter = deleteAttachmentRouter;
    this.retrieveMetadataRouter = retrieveMetadataRouter;
  }

  public void run(String... args) {
    saveAttachmentRouter.bind();
    retrieveAttachmentRouter.bind();
    deleteAttachmentRouter.bind();
    retrieveMetadataRouter.bind();
    javalin.start(8088);
  }
}
