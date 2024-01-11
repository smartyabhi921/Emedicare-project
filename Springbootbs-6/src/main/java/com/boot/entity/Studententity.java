package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Studententity 
{   
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int studentIdl;
   
	
   @Column(nullable = false , length = 400)
   private String studentName;
   
   @Column(unique = true)
   private String studentEmail;
   
   @Column(nullable = false,length = 10)
   private String studentPassword;
   
   @Column(nullable = false)
   private String studentAge;
   
   @Column(nullable = false)
   private String studentClass;

public int getStudentIdl() {
	return studentIdl;
}

public void setStudentIdl(int studentIdl) {
	this.studentIdl = studentIdl;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public String getStudentEmail() {
	return studentEmail;
}

public void setStudentEmail(String studentEmail) {
	this.studentEmail = studentEmail;
}

public String getStudentPassword() {
	return studentPassword;
}

public void setStudentPassword(String studentPassword) {
	this.studentPassword = studentPassword;
}

public String getStudentAge() {
	return studentAge;
}

public void setStudentAge(String studentAge) {
	this.studentAge = studentAge;
}

public String getStudentClass() {
	return studentClass;
}

public void setStudentClass(String studentClass) {
	this.studentClass = studentClass;
}

public Studententity() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Studententity [studentIdl=" + studentIdl + ", studentName=" + studentName + ", studentEmail=" + studentEmail
			+ ", studentPassword=" + studentPassword + ", studentAge=" + studentAge + ", studentClass=" + studentClass
			+ "]";
}
   
   
         
   
	}
