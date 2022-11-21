package com.mercadolibre.javalin.repositories.employees;

import com.mercadolibre.javalin.domain.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeRepository {

    List<EmployeeDTO> litAll();
}
