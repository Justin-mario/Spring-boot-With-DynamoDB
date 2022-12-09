package com.awsdynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@DynamoDBDocument
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address implements Serializable {

    @DynamoDBAttribute
    private int houseNumber;

    @DynamoDBAttribute
    private String streetName;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String State;
}
