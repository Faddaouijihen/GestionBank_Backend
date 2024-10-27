package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.EmployeeDto;
import com.GestionBank.GestionBank.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee createEmployee(EmployeeDto dto) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return null;
    }

    @Override
    public Employee affecterEmployeeAUnGroup(EmployeeDto dto) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployeesByGroupId(long id) {
        return List.of();
    }
}