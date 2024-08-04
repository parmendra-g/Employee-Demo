package com.demo.controller;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public Employee createEmp(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmp() {
        return service.getAllEmployee();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Integer id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Integer id) {
        service.deleteEmployeeById(id);
        return ResponseEntity.ok(" Employee Deleted, id : " + id);
    }
}
