package com.springBoot.springRestCrud.dao;

import com.springBoot.springRestCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
     List<Employee> findall();
     Employee findById(Integer id);
     Employee save(Employee theEmployee);
     void deleteById(Integer id);

}
