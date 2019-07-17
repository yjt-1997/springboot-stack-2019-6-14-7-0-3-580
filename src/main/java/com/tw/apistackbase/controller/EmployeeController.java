package com.tw.apistackbase.controller;


import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> list() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable String employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping(value = "/employees", params = "leastAge")
    public List<Employee> findAgeMoreThan(@RequestParam int leastAge) {
        return employeeService.findAll().stream().filter(employee -> employee.getAge() > leastAge).collect(Collectors.toList());
    }

    @RequestMapping(value = "/employees", method = {RequestMethod.POST, RequestMethod.PUT})
    public Employee updateOrSave(@RequestBody Employee employee) {
        return employeeService.updateOrSave(employee);
    }

    @DeleteMapping("/employees/{employeeID}")
    public void delete(String employeeID) {
        employeeService.delete(employeeID);
    }
}
