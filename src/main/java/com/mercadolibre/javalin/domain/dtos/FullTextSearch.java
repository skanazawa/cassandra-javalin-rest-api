package com.mercadolibre.javalin.domain.dtos;

import lombok.Data;

@Data
public class FullTextSearch {
  private String text;
  private String year;
}
