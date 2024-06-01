package com.springBoot.springRestCrud.rest;

import com.springBoot.springRestCrud.entity.Employee;
import com.springBoot.springRestCrud.service.EmployeeService;
import com.springBoot.springRestCrud.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeService emps;

    public EmployeeRestController(EmployeeService emps) {
        this.emps = emps;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
    return emps.findall();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee empf = emps.findById(employeeId);
        if (empf == null){
            throw new RuntimeException("Employee is not found: "+employeeId);
        }
        return empf;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //@RequestBody: if data is sent in json format then it is typecasted
        // to object with the help of jackson
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save(entityManager.merge() method) of new item ... instead of update
        theEmployee.setId(0);
        return emps.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return emps.save(theEmployee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId){
        Employee empls = emps.findById(employeeId);
        if(empls==null){
            throw new RuntimeException("Employee with this id not found :" + employeeId);
        }
        emps.deleteById(employeeId);
        return "Deleted Employee with id: "+employeeId;
    }
}
