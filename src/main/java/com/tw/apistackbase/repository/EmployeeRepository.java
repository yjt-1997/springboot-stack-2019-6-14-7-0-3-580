package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Employee;

import java.util.*;

public class EmployeeRepository {

    private static Map<String, Employee> employees = new HashMap<>();

    static {
        addEmployee("Xiaoming", 20, "Male");
        addEmployee("Xiaohong", 19, "Female");
        addEmployee("Xiaozhi", 15, "Male");
        addEmployee("Xiaogang", 16, "Male");
    }

    private static void addEmployee(String name, int age, String gender) {
        String employeeId = UUID.randomUUID().toString();
        Employee employee = new Employee(employeeId, name, age, gender);
        employees.put(employeeId, employee);
    }

    public List<Employee> findAll() {
        return new ArrayList<Employee>(employees.values());
    }

    public Employee findById(String employeeId) {
        return employees.get(employeeId);
    }

    public Employee updateOrSave(Employee employee) {
        if (employee.getId() == null || employees.containsKey(employee.getId())) {
            String employeeId = UUID.randomUUID().toString();
            employee.setId(employeeId);
            employees.put(employeeId, employee);
        } else {
            employees.put(employee.getId(), employee);
        }
        return employee;
    }

    public void delete(String employeeId){
        employees.remove(employeeId);
    }
}
