package com.employeeportal.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping(produces = "application/json")
    public List<Employee> getSortedEmployees() {
	return employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee user) {
	employees.add(user);
	return user;
    }

}