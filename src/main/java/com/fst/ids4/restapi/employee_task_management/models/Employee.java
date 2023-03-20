package com.fst.ids4.restapi.employee_task_management.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String accountName;
    private String grade;

    private Employee master;

    public Employee(String firstName, String lastName, String address, String accountName, String grade,
    Employee master) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.accountName = accountName;
        this.grade = grade;
        this.master = master;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Employee getMaster() {
        return master;
    }

    public void setMaster(Employee master) {
        this.master = master;
    }

}