package org.transportreservation.service;


import org.springframework.stereotype.Service;
import org.transportreservation.model.Employee;
import org.transportreservation.repository.EmployeeDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee insertEmployee(Employee employee) throws SQLException {
        employeeDAO.insert(employee);
        return employee;
    }

    public List<Employee> getAll() throws SQLException {
        return employeeDAO.getAll();
    }
}
