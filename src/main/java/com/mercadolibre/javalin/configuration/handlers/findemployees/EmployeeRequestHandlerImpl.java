package com.mercadolibre.javalin.configuration.handlers.findemployees;

import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.employees.EmployeeService;
import io.javalin.http.ContentType;
import io.javalin.http.Context;

/**
 *
 */
public class EmployeeRequestHandlerImpl implements EmployeeRequestHandler {

    private EmployeeService employeeService;

    @Inject
    public EmployeeRequestHandlerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Context get(Context ctx) {
        return ctx.contentType(ContentType.APPLICATION_JSON).json(employeeService.listAll());
    }
}
