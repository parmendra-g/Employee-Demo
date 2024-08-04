package com.demo.service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repository;

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Employee createEmployee(Employee emp) {
        return repository.save(emp);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee savedEmployee = repository.findById(id).orElseThrow();

        savedEmployee.setName(employee.getName());
        savedEmployee.setEmail(employee.getEmail());
        savedEmployee.setLocation(employee.getLocation());
        savedEmployee.setDob(employee.getDob());
        return repository.save(savedEmployee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        repository.deleteById(id);

    }
}
