package com.springBoot.springRestCrud.service;

import com.springBoot.springRestCrud.entity.Employee;

import java.util.List;

//Service layer is used as it is a standard design patter known as service facade
//we can apply businees login in service layer and collect results from multiple resources
// and send single response to controller
public interface EmployeeService {
    List<Employee> findall();
    Employee findById(Integer id);
    Employee save(Employee theEmployee);
    void deleteById(Integer id);
}
