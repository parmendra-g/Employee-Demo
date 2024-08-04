package com.demo.service;

import com.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Optional<Employee> getEmployeeById(Integer id);

    public Employee createEmployee(Employee emp);

    public Employee updateEmployee(Integer id, Employee emp);

    public void deleteEmployeeById(Integer id);
}
