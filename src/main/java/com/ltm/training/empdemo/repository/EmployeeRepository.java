package com.ltm.training.empdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltm.training.empdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
