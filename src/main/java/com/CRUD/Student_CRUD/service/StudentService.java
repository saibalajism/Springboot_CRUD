package com.CRUD.Student_CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CRUD.Student_CRUD.dto.StudentDto;
import com.CRUD.Student_CRUD.entity.Student;
import com.CRUD.Student_CRUD.repository.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepository;
	
	
	@Autowired
	private ObjectMapper mapper;
	
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
	public  ResponseEntity<Object>  updateStudent(StudentDto dto, int StudentId) {
		Student a=studentRepository.findById(StudentId).orElse(null);
		if(a==null) {
			ObjectNode errorResponse = mapper.createObjectNode();
            errorResponse.put("message", "Student does not exist");
            errorResponse.put("httpStatusCode", 404);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}else {
			a.setStudentName(dto.getStudentName());
			a.setMarks(dto.getMarks());
		    a.setAddress(dto.getAddress());
		    ObjectNode successResponse = mapper.createObjectNode();
		    successResponse.put("message", "Student updated");
		    successResponse.put("httpStatusCode", 200);
		    successResponse.set("data",mapper.valueToTree(studentRepository.save(a)));
		    return new ResponseEntity<>(successResponse, HttpStatus.OK);
		}
		
	}

}
