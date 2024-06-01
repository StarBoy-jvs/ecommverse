package com.springBoot.springRestCrud.service;

import com.springBoot.springRestCrud.dao.EmployeeDAO;
import com.springBoot.springRestCrud.dao.EmployeeDAOImpl;
import com.springBoot.springRestCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO empd;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOImpl empd) {
        this.empd = empd;
    }

    @Override
    public List<Employee> findall() {
        return empd.findall();
    }

    @Override
    public Employee findById(Integer id) {
        return empd.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return empd.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) {
    empd.deleteById(id);
    }
}
