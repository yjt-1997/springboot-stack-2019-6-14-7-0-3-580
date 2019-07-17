package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private MyRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(String employeeId) {
        return repository.findById(employeeId);
    }

    public Employee updateOrSave(Employee employee) {
        return repository.updateOrSave(employee);
    }

    public void delete(String employeeId) {
        repository.delete(employeeId);
    }
}
