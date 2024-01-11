package com.boot.service;

import com.boot.entity.Studententity;

import java.security.PublicKey;
import java.util.*;

public interface StudentaService

{
   //add new record
	public Studententity addStudent(Studententity student);
	
	//to get  all the student list
	public List<Studententity> getAllstudents();
	
	//to get rec by id
	public Studententity getStudentById(int studentId);
	
	//update by student id
	public Studententity updateStudentById(Studententity student,int studentId);
	
	//del
	public void deleteStudentByID(int studentID);

		
}
