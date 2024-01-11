package com.boot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Studententity;
import com.boot.exceptions.ApiResponce;
import com.boot.service.StudentaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")

@Api(value="", tags= {"Medicine-controller"}, description="Operate and Perform functions about Medicines.")
public class StudentController 

{   @Autowired
	private StudentaService studentaService;
	
    @PostMapping("/") //end point http:localhost:8080/student
	public ResponseEntity<Studententity> addStudent(@RequestBody Studententity student)
	{
    
    	Studententity savestudent = this.studentaService.addStudent(student);
       return new ResponseEntity<Studententity>(savestudent,HttpStatus.CREATED);
    	
	}
    
    
    // get records
    @GetMapping("/")
    public ResponseEntity<List<Studententity>> getAllstudents()
    {
        List<Studententity> allStudents = this.studentaService.getAllstudents();
        return new ResponseEntity<List<Studententity>>(allStudents,HttpStatus.OK);

    }
    
    @GetMapping("/{studentId}")
    public ResponseEntity<Studententity> getStudentById(@PathVariable("studentId")int studentId )
    {
    	
    Studententity studentById = this.studentaService.getStudentById(studentId);	
    return new ResponseEntity<Studententity>(studentById,HttpStatus.OK);	
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Studententity> updateStudentbyID(@RequestBody Studententity student,@PathVariable("studentId") int studentId)
    {
    	Studententity updatedStudent = this.studentaService.updateStudentById(student, studentId);
    	return new ResponseEntity<Studententity>( updatedStudent ,HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponce> deleteById(@PathVariable("studentId")int studentId )
    {
    	
    this.studentaService.deleteStudentByID(studentId);	
    ApiResponce response = new ApiResponce();
    response.setMessage("Student record is deleted wiith id"+ studentId);
    
    return new ResponseEntity<ApiResponce>(response,HttpStatus.OK);	
    }
    
}


