package com.devops.Artifact.employee_management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
        employees.add(new Employee(1, "John", "IT"));
        employees.add(new Employee(2, "Alice", "HR"));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }
}