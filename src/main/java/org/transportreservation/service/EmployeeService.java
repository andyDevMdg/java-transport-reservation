package org.transportreservation.service;


import org.transportreservation.model.Employee;
import org.transportreservation.repository.EmployeeDAO;

import java.sql.SQLException;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee insertCustomer(Employee employee) throws SQLException {
        employeeDAO.insert(employee);
        return employee;
    }
}
