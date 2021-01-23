package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load the student data ... only once!
	//just return theStudents, it has already been loaded bc of PostConstruct
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();//a list of classes
		
		theStudents.add(new Student("Tony","Trinh"));
		theStudents.add(new Student("Mario","Rossi"));
		theStudents.add(new Student("Mary","Smith"));
		
	}
	
	
	
	//define endpoint for "/students" - return list of student
	
	@GetMapping("/students")
	public List<Student> getStudents(){

		return theStudents;
	}
	
	//define endpoint for "/students/{studentId}"
	//{} signifies pathvariable
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//check the studentId against list size 
		
		if ((studentId >= theStudents.size())|| (studentId<0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		//just index into the list ... keep it simple for now
		//theStudents.get(1) - returns element within index 1
		
		return theStudents.get(studentId); //get method for arraylist returns method of each element
	}

}
