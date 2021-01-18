package com.luv2code.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")

//annotating our java class
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//actual name of column in database
    private int id;

    @Column(name = "first_name")//actual name of column in database
    private String firstName;

    @Column(name = "last_name")//actual name of column in database
    private String lastName;

    @Column(name = "email")//actual name of column in database
    private String email;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})

    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name="student_id"), //inverse joincolumns
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses;

    //ok here is the default constructor
    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    //good for debugging purposes
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
