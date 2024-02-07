import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route , Router } from '@angular/router';
import Swal from 'sweetalert2';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
  preserveWhitespaces:true,
})
export class AddStudentComponent implements OnInit {

studentReg:FormGroup;

  constructor(private _studentService:StudentService,
              private _formBuilder:FormBuilder,
              private _router:Router
               )
   {

          this.studentReg=this._formBuilder.group(

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

  ngOnInit(): void {

  }
  register()
 { 
//alert("hello"); 
if(this.studentReg.valid)

{
  Swal.fire({
    title: 'Do you want to save the changes?',
    showDenyButton: true,
    showCancelButton: true,
    confirmButtonText: 'Save',
    denyButtonText: `Don't save`,
  }).then((result) => {

    /* Read more about isConfirmed, isDenied below */
    if (result.isConfirmed) 
    {
      this._studentService.addStudent(this.studentReg.value).subscribe(response=>
        {
          Swal.fire('your record is saved', '', 'success')
          this._router.navigate(['/student-list']);
        },

        (error=>
          {
            console.log(error);
          })
        );
        Swal.fire('Saved!', '', 'success')
        
      } else if (result.isDenied) {
         Swal.fire('Changes are not saved', '', 'info')
       }
     })
     
     console.log(this.studentReg.valid);
 
      this._studentService.addStudent(this.studentReg.value).subscribe(response=>
       {
         console.log
        },
 
        (error=>
          {
            console.log(error);
          })
          );
       
         };
  
   console.log(this.studentReg.valid);
   //console.log(this.studentReg.value);
 
        }
}
