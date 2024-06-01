package com.springBoot.springRestCrud.dao;

import com.springBoot.springRestCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager theEntityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        theEntityManager = em;
    }

    @Override
    public List<Employee> findall() {
        TypedQuery<Employee> query = theEntityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee empl = theEntityManager.find(Employee.class,id);
        return empl;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee emply = theEntityManager.merge(theEmployee);
        return emply;
    }

    @Override
    public void deleteById(Integer id) {
        Employee emplyo = theEntityManager.find(Employee.class,id);
        theEntityManager.remove(emplyo);
    }
}

