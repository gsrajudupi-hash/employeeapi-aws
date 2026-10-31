package com.ltm.training.empdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltm.training.empdemo.model.Employee;
import com.ltm.training.empdemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(
            EmployeeRepository repository) {

        this.repository = repository;
    }

    @PostMapping
    public Employee saveEmployee(
            @RequestBody Employee employee) {

        return repository.save(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(
            @PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Employee not found"));
    }
}
