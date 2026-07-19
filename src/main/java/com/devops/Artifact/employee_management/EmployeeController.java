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

    @GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable int id) {
    for (Employee employee : employees) {
        if (employee.getId() == id) {
            return employee;
        }
    }
    return null;
}
@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {

    for (Employee employee : employees) {

        if (employee.getId() == id) {

            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());

            return employee;
        }
    }

    return null;
}
}