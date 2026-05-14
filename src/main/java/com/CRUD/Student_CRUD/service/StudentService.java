package com.CRUD.Student_CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.Student_CRUD.dto.StudentDto;
import com.CRUD.Student_CRUD.entity.Student;
import com.CRUD.Student_CRUD.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepository;
	
	public Student StudentCreate(StudentDto dto)
	{
		 Student student =new Student();
		 student.setStudentName(dto.getStudentName());
		 student.setMarks(dto.getMarks());
		 student.setAddress(dto.getAddress());
		 
		 return studentRepository.save(student);
		 
	}
	public List<Student> fetchStudent(){
		return studentRepository.findAll();
	}
	public Student fetchStudentbyId(int StudentID) {
		return studentRepository.findById(StudentID).get();		
	}

}
