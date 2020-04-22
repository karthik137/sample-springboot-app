package com.kirito.testserver.resource;

import com.kirito.testserver.repository.EmployeeRepository;
import com.kirito.testserver.user.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;


    Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    @GetMapping("/employees")
    public List<Employee> getListOfEmployees(){

        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }



    @GetMapping("/employee/{id}")
    public Employee getEMployee(@PathVariable int id){

        Employee employee = employeeRepository.getOne(id);
        logger.info("Printing employee -> "+employee.toString());
        logger.info("Returning employee details");
        return employee;
    }


    @PostMapping("/employee")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        URI location =   ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
