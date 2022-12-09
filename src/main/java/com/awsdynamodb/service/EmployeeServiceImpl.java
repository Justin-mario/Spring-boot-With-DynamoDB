package com.awsdynamodb.service;

import com.awsdynamodb.entity.Employee;
import com.awsdynamodb.exception.EmployeeNotFoundException;
import com.awsdynamodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save ( employee );
    }

    public Employee findById(String employeeId){
        Optional<Employee> employee = Optional.ofNullable ( employeeRepository.findById ( employeeId ) );
        if (employee.isEmpty ()){
            throw new EmployeeNotFoundException ("Employee with Id " + employeeId +" does not exist ");
        }
        return employee.get ();
    }

    public String updateEmployeeRecord(Employee employee){
        employeeRepository.update ( employee );
        return "Record Updated";
    }

    public String delete(Employee employee){
        employeeRepository.delete ( employee);
        return "employee has been deleted";
    }
}
