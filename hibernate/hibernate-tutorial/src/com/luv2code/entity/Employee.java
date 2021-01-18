package com.luv2code.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")

//annotating our java class
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//actual name of column in database
    private int id;

    @Column(name = "first_name")//actual name of column in database
    private String firstName;

    @Column(name = "last_name")//actual name of column in database
    private String lastName;

    @Column(name = "company")//actual name of column in database
    private String company;

    //ok here is the default constructor
    public Employee(){

    }

    public Employee(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    //good for debugging purposes
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
