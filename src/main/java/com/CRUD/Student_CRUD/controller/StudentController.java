package com.CRUD.Student_CRUD.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.Student_CRUD.dto.StudentDto;
import com.CRUD.Student_CRUD.entity.Student;
import com.CRUD.Student_CRUD.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController

@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public Student StudentCreate(@RequestBody StudentDto dto) {
		return studentService.StudentCreate(dto);
	}
	@GetMapping("/all")
	public List<Student> fetchStudent() {
		return studentService.fetchStudent();
	}
	@GetMapping("/{StudentID}")
	public Student fetchStudent(@PathVariable("StudentID") int StudentID) {
		return studentService.fetchStudentbyId(StudentID);
	}
	@PutMapping("/update/{StudentID}")
	public  ResponseEntity<Object> updateStudent(@RequestBody StudentDto dto, @PathVariable("StudentID") int StudentID) {
		return studentService.updateStudent(dto, StudentID);
	}
	
}

