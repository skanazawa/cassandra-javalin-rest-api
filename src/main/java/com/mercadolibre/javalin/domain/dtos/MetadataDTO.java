package com.mercadolibre.javalin.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
public class MetadataDTO {

    String mimeType;
    String originalFileName;
    Long fileSize;
    Encoding encoding;
    boolean isPotentialThreat;


    public enum Encoding {

        BINARY("binary");

        private final String encoding;

        Encoding(String encoding) {
            this.encoding = encoding;
        }

        public String getEncoding() {
            return encoding;
        }

    }

}
