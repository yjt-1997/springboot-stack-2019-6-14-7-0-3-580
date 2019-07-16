package com.tw.apistackbase.controller;


import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping("/employees")
    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @GetMapping("/employees/leastAge/{leastAge}")
    public List<Employee> findAgeMoreThan(@PathVariable String leastAge) {
        return employeeRepository.findAll().stream().filter(employee -> employee.getAge() > Integer.parseInt(leastAge)).collect(Collectors.toList());
    }

    @PutMapping("/employees")
    public Employee updateOrSave(@RequestBody Employee employee){
        return employeeRepository.updateOrSave(employee);
    }
}
