package com.mercadolibre.javalin.domain.employees.impl;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.EmployeeDTO;
import com.mercadolibre.javalin.repositories.employees.EmployeeRepository;
import com.mercadolibre.javalin.domain.employees.EmployeeService;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Override
    public List<EmployeeDTO> listAll() {
        return employeeRepository.litAll();
    }
}
