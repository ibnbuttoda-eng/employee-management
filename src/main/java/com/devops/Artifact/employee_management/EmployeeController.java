package com.devops.Artifact.employee_management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
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
@DeleteMapping("/{id}")
public String deleteEmployee(@PathVariable int id) {

    for (Employee employee : employees) {

        if (employee.getId() == id) {

            employees.remove(employee);
            return "Employee deleted successfully";
        }
    }

    return "Employee not found";
}
}