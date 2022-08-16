package io.zipcoder.crudapp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int iD;
    String firstName;
    String lastName;

}
