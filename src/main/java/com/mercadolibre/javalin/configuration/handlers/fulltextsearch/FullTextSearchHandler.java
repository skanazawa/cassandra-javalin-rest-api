package com.mercadolibre.javalin.configuration.handlers.fulltextsearch;

import io.javalin.http.Context;

public interface FullTextSearchHandler {
  Context post(Context ctx);
}
