package com.mercadolibre.javalin.domain.employees;

import com.mercadolibre.javalin.domain.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> listAll();
}
