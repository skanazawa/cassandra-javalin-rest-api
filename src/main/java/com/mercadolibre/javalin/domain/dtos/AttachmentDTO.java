package com.mercadolibre.javalin.domain.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttachmentDTO {
    String mimeType;
    byte[] file;
}
