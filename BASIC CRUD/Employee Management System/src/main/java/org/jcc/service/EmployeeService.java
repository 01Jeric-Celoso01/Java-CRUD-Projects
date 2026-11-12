package org.jcc.service;

import org.jcc.model.Employee;
import org.jcc.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee) {
        employeeRepository.createEmployee(employee);
        return employee;
    }

    public List<Employee> viewAllEmployees() {
        return employeeRepository.viewAllEmployee();
    }

    public Employee searchEmployeeById(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        return employeeRepository.searchEmployeeById(id);
    }

    public Employee updateEmployeeById(String employeeId) {
        if (employeeId == null || employeeId.isBlank()) {
            return null;
        }

        return employeeRepository.updateEmployeeById(employeeId);
    }

    public Employee  deleteEmployeeById(String employeeId) {
        if (employeeId == null || employeeId.isBlank()) {
            return null;
        }

        return employeeRepository.deleteEmployeeById(employeeId);
    }
}
