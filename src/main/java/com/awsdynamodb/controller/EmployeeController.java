package com.awsdynamodb.controller;

import com.awsdynamodb.entity.Employee;
import com.awsdynamodb.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<> ( employeeService.saveEmployee ( employee ), HttpStatus.CREATED );
    }

    @GetMapping("/find-by-id/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String employeeId){
        return new ResponseEntity<> ( employeeService.findById ( employeeId), HttpStatus.OK );
    }

    @DeleteMapping("/delete-employee")
    public ResponseEntity<?> deleteEmployee(@RequestBody Employee employee){
        return new ResponseEntity<> ( employeeService.delete ( employee ), HttpStatus.OK ) ;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployeeRecord(@RequestBody Employee employee){
        return new ResponseEntity<> ( employeeService.updateEmployeeRecord ( employee ), HttpStatus.OK );
    }
}
