package org.jcc.repository;

import org.jcc.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee createEmployee(Employee employee);
    List<Employee> viewAllEmployee();
    Employee searchEmployeeById(String id);
    Employee updateEmployeeById(String id);
    Employee deleteEmployeeById(String id);
}
