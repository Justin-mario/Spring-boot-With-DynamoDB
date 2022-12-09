package com.awsdynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.awsdynamodb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Employee save(Employee employee){
        mapper.save ( employee );
        return employee;
    }

    public Employee findById(String employeeId){
        return mapper.load (Employee.class, employeeId  );
    }

    public String delete(Employee employeeId){
        mapper.delete ( employeeId );
        return "employee " + employeeId + " deleted successfully";
    }

    public String update(Employee employee){
        mapper.save ( employee, buildExpression ( employee ) );
        return "record updated";
    }

    private DynamoDBSaveExpression buildExpression(Employee employee){

        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression ();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<> ();
        expectedMap.put ( "employeeId", new ExpectedAttributeValue (new AttributeValue ().withS ( employee.getEmployeeId () ) ) );
        dynamoDBSaveExpression.setExpected (expectedMap);
        return dynamoDBSaveExpression;
    }
}
