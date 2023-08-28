package org.transportreservation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.transportreservation.model.Employee;
import org.transportreservation.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) throws SQLException {
        return employeeService.insertEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployee() throws SQLException {
        return employeeService.getAll();
    }

}
