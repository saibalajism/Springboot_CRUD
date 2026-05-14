package com.CRUD.Student_CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.Student_CRUD.dto.StudentDto;
import com.CRUD.Student_CRUD.entity.Student;
import com.CRUD.Student_CRUD.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public Student StudentCreate(@RequestBody StudentDto dto) {
		return studentService.StudentCreate(dto);
	}

}
