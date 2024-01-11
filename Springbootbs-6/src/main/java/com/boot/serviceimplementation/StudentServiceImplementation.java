package com.boot.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Studententity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.StudentRepository;
import com.boot.service.StudentaService;



@Service
public class StudentServiceImplementation implements StudentaService

{  
	
	@Autowired
   private StudentRepository studentRepository;
	
	
	@Override
	public Studententity addStudent(Studententity student) {
		// TODO Auto-generated method stub
		return this.studentRepository.save(student);
	}

	@Override
	public List<Studententity> getAllstudents() {
		// TODO Auto-generated method stub
		return this.studentRepository.findAll();
	}

	@Override
	public Studententity getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student", "studentId", studentId));
	}

	@Override
	public Studententity updateStudentById(Studententity student, int studentId) {
		
		
	this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student", "studentId", studentId));
		
	 return this.studentRepository.save(student);
	}

	@Override
	public void deleteStudentByID(int studentId) 
	
	{
		this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student", "studentId", studentId));
	
		this.studentRepository.deleteById(studentId);
	}

}
