package com.mercadolibre.javalin.domain.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class SearchTextResponse {

  private Long quantity;
}
