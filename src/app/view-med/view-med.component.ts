import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-view-med',
  templateUrl: './view-med.component.html',
  styleUrls: ['./view-med.component.css']
})
export class ViewMedComponent implements OnInit {

  studentList:Student[]=[];
  
  constructor(private _studentService:StudentService) 
  { }

  ngOnInit(): void 
  
  {
    this.getAllStudentDetails();
  }
  getAllStudentDetails()
  {
    this._studentService.getAllStudent().subscribe((response:Student[])=>
    {
       
        this.studentList=response;
    },(error=>
      {
        console.log(error);
      }
      
    )
  );

  }
}
