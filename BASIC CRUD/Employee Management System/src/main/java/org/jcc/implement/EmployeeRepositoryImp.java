package org.jcc.implement;

import org.jcc.data.EmployeeData;
import org.jcc.model.Employee;
import org.jcc.repository.EmployeeRepository;
import org.jcc.ui.UIDesign;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImp implements EmployeeRepository {

    private final List<Employee> EMPLOYEES = new ArrayList<Employee>(EmployeeData.sampleData());

    @Override
    public Employee createEmployee(Employee employee) {
        EMPLOYEES.add(employee);
        return employee;
    }

    @Override
    public List<Employee> viewAllEmployee() {
        return EMPLOYEES;
    }

    @Override
    public Employee searchEmployeeById(String id) {
        if (id == null) {
            UIDesign.statusDesign("INVALID ID");
        }

        for (Employee employee : EMPLOYEES) {
            if (id.equalsIgnoreCase(employee.getId())) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public Employee updateEmployeeById(String id) {
        if (id == null) {
            UIDesign.statusDesign("EMPLOYEE NOT FOUND");
        }

        for (Employee employee : EMPLOYEES) {
            if (id.equalsIgnoreCase(employee.getId())) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public Employee deleteEmployeeById(String id) {
        if (id == null) {
            UIDesign.statusDesign("EMPLOYEE NOT FOUND");
        }

        for (Employee employee : EMPLOYEES) {
            if (employee.getId().equalsIgnoreCase(id)) {
                EMPLOYEES.remove(employee);
                return employee;
            }
        }

        return null;
    }
}
