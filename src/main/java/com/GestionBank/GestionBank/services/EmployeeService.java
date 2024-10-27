package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.EmployeeDto;
import com.GestionBank.GestionBank.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto dto);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee affecterEmployeeAUnGroup(EmployeeDto dto);
    List<Employee> getAllEmployeesByGroupId(long id);
}