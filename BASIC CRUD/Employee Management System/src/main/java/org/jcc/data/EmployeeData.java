package org.jcc.data;

import org.jcc.enums.Departments;
import org.jcc.enums.EmployeeType;
import org.jcc.model.Employee;
import org.jcc.util.GenerateAge;
import org.jcc.util.GenerateCurrentDate;
import org.jcc.util.GenerateEmployeeID;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> sampleData() {
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee(GenerateEmployeeID.generateEmployeeId(), "Jane", "D.",  "Doe", "Female", "10152001", (int) GenerateAge.generateAge("10152001"), "09123456789", "janeCruzDelaDoe@gmail.com", "019-C Kasunduan St Brgy Commonwealth Quezon City", Departments.Customer_Service, "Customer Service Representative", EmployeeType.Full_Time, GenerateCurrentDate.currentDate(), 20000);
        employees.add(emp1);

        Employee emp2 = new Employee(GenerateEmployeeID.generateEmployeeId(), "Juan", "D.",  "Cruz", "Male", "03011999", (int) GenerateAge.generateAge("03011999"), "09987654321", "juan@gmail.com", "New Manila", Departments.Human_Resources, "HR Assistant", EmployeeType.Probationary, GenerateCurrentDate.currentDate(), 18000);
        employees.add(emp2);

        return employees;
    }
}
