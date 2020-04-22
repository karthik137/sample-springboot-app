package com.kirito.testserver.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @GeneratedValue
    @Id
    private int id;

    private String employeeName;

    private String emailId;

    public Employee() {
    }

    public Employee(int id, String employeeName, String emailId) {
        this.id = id;
        this.employeeName = employeeName;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
