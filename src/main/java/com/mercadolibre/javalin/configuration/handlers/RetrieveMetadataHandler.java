package com.mercadolibre.javalin.configuration.handlers;

import io.javalin.http.Context;

public interface RetrieveMetadataHandler {

  Context retrieveMetadata(Context ctx);

}
