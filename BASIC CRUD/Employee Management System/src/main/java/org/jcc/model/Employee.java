package org.jcc.model;

import org.jcc.enums.Departments;
import org.jcc.enums.EmployeeType;
import org.jcc.ui.UIDesign;

public class Employee {
    private String id;
    private String fName;
    private String mName;
    private String lName;
    private String gender;
    private String birthDate;
    private int age;
    private String number;
    private String email;
    private String address;
    private Departments department;
    private String position;
    private EmployeeType employeeType;
    private String hiredDate;
    private double salary;

    public Employee(String id, String fName, String mName, String lName, String gender, String birthDate, int age, String number, String email, String address, Departments department, String position, EmployeeType employeeType, String hiredDate, double salary) {
        this.id = id;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.number = number;
        this.email = email;
        this.address = address;
        this.department = department;
        this.position = position;
        this.employeeType = employeeType;
        this.hiredDate = hiredDate;
        this.salary = salary;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() {
        return fName + " " + mName + " " + lName;
    }

    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }

    public String getmName() { return mName; }
    public void setmName(String mName) { this.mName = mName; }

    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthDate() {
        if (birthDate == null || birthDate.length() != 8) {
            return birthDate;
        }

        return birthDate.substring(0, 2) + "/" + birthDate.substring(2, 4) + "/" + birthDate.substring(4, 8);
    }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate;}

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getNumber() { return number; }
    public void setNumber(String number) {this.number = number; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Departments getDepartment() { return department; }
    public void setDepartment(Departments department) { this.department = department; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public EmployeeType getEmployeeType() { return employeeType; }
    public void setEmployeeType(EmployeeType employeeType) { this.employeeType = employeeType; }

    public String getHiredDate() {
        if (hiredDate == null || hiredDate.length() != 8) {
            return hiredDate;
        }
        return hiredDate.substring(0, 2) + "/" + birthDate.substring(2, 4) + "/" + birthDate.substring(4, 8);
    }
    public void setHiredDate(String hiredDate) { this.hiredDate = hiredDate; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void employeeById() {
        System.out.printf("|| EMPLOYEE ID: %-10s || FULL NAME: %-30s || BIRTH DATE: %-10s || AGE: %-6s || GENDER: %-14s || PHONE: %-15s ||\n", id, getFullName(), getBirthDate(), age, gender, number);
        System.out.printf("|| EMAIL: %-61s || ADDRESS: %-80s ||\n", email, address);
        System.out.printf("|| DEPARTMENT: %-28s || POSITION %-36s || TYPE: %-13s || SALARY: %-9s || DATE HIRED: %-13s||\n", department, position, employeeType, salary, getHiredDate());
        UIDesign.crossBorder();
        System.out.println("\n\n");

    }
}


