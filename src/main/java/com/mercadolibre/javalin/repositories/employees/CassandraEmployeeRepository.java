package com.mercadolibre.javalin.repositories.employees;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CassandraEmployeeRepository implements EmployeeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraEmployeeRepository.class);
    private final CqlSession session;

    @Inject
    public CassandraEmployeeRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public List<EmployeeDTO> litAll() {
        Select select = QueryBuilder.selectFrom("employees").all();
        SimpleStatement simpleStatement = select.build();
        ResultSet resultSet = session.execute(simpleStatement);

        return resultSet.all().stream().map(this::getEmployeeDTO).collect(Collectors.toList());
    }

    private EmployeeDTO getEmployeeDTO(Row row) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(row.getLong("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .city(row.getString("city"))
                .phone(row.getString("phone"))
                .salary(row.getString("salary"))
                .build();
        return employeeDTO;
    }

}
