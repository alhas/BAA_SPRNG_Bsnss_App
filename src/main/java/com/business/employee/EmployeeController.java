package com.business.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();

    }

    @PostMapping
    public void newEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {

        employeeService.deleteEmployee(employeeId);

    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){

        employeeService.updateEmployee(employeeId,employee);

    }


}
