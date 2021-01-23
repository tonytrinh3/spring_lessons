package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true)//to deal with unknown properties
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	
	private Address address;
	
	private String[] languages;
	
	//https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/10289822#questions/13229626
	public Student() {
//		I personally always write default constructor AND constructor with args, it is like a ritual that I never stopped doing.
//
//		But what you need to understand is that it is NEVER a bad thing to define a default constructor in your class.
		
//		Hey Andrey, one way or another object will need an instruction on how to be created ( constructor ) and 
//		the safest bet is to create no argument constructor because, most of the tech that people use ( hibernate, JPA )
//		it requires an explicitly defined default constructor.
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	

}
