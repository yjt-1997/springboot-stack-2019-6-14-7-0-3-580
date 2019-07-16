package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Employee;

import java.util.List;

public interface Repository {

    List<Employee> findAll();

    Employee findById(String employeeId);

    Employee updateOrSave(Employee employee);

    void delete(String employeeId);
}
