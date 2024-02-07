import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Student } from '../model/student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css'],
  preserveWhitespaces:true,

})
export class UpdateStudentComponent implements OnInit {
  sid:number;
  student:Student;
  updatestudentForm:FormGroup;

  constructor(private _activatedRoute:ActivatedRoute,
             private _studentservice:StudentService,
              private _formbuilder:FormBuilder,
              private _route:Router ) 
  {
   this.updatestudentForm=_formbuilder.group(

    {
      studentIdl:[0], 
      studentName:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
     studentEmail:['',Validators.compose([Validators.required,Validators.email])],
     studentPassword:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
      studentAge:['',Validators.compose([Validators.required,Validators.min(10),Validators.max(30)])],  
     studentClass:['',Validators.compose([Validators.required,Validators.minLength(2),Validators.maxLength(10)])], 
    }
   );
  }
  ngOnInit(): void 
  {

    this.sid= this._activatedRoute.snapshot.params['studentIdl'];

    this._studentservice.getStudentById(this.sid).subscribe(response=>
      {
               this.student=response;
               console.log(response);
               this.updatestudentForm=this._formbuilder.group(

                {
                  studentIdl:[response.studentIdl], 
                  studentName:[response.studentName,Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
                 studentEmail:[response.studentEmail,Validators.compose([Validators.required,Validators.email])],
                 studentPassword:[response.studentPassword,Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
                  studentAge:[response.studentAge,Validators.compose([Validators.required,Validators.min(10),Validators.max(30)])],  
                 studentClass:[response.studentClass,Validators.compose([Validators.required,Validators.minLength(2),Validators.maxLength(10)])], 
                }
               );
         
      },
      (error=> 
        {
          console.log(error);
        }
      )
    )
    // alert(this.sid);

  }

updatestudent()
{
   if(this.updatestudentForm.valid)
   {
    Swal.fire({
      title: 'Do you want to update the changes?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'update',
      denyButtonText: `Don't update`,
    }).then((result) => {
  
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) 
      {
        this._studentservice.updatestudentById(this.sid,this.updatestudentForm.value).subscribe(response=>
          {
            Swal.fire('your record is updated', '', 'success');
            console.log(response);
            this._route.navigate(['student-list']);

          },
  
          (error=>
            {
              console.log(error);
            })
          );
                  
        } else if (result.isDenied) {
           Swal.fire('Changes are not updated', '', 'info')
         }
       })
   }
}
    
}
