package com.mercadolibre.javalin.domain.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
@JsonAutoDetect
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String salary;

}
