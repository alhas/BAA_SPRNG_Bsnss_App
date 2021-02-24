package com.business.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Email is taken, Employee Exist");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {

        boolean checkId = employeeRepository.existsById(employeeId);
        if (!checkId) {
            throw new IllegalStateException("There is no employee with this id.");
        }
        employeeRepository.deleteById(employeeId);


    }

    public void updateEmployee(Long employeeId, Employee employee) {

        boolean chekId = employeeRepository.existsById(employeeId);
        if (!chekId) {
            throw new IllegalStateException("There is no employee with this id.");
        }

        employeeRepository.findById(employeeId).map(newData -> {
            newData.setEmail(employee.getEmail());
            newData.setName(employee.getName());
            newData.setMidname(employee.getMidname());
            newData.setSurname(employee.getSurname());
            newData.setPosition(employee.getPosition());
            newData.setPhoneNumber(employee.getPhoneNumber());
            newData.setImageUrl(employee.getImageUrl());
            newData.setStartDate(employee.getStartDate());
            return employeeRepository.save(newData);
        }).orElseGet((() -> {
            employee.setId(employeeId);
            return employeeRepository.save(employee);
        }));


    }
}




















