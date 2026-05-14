package com.CRUD.Student_CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.Student_CRUD.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	

}
