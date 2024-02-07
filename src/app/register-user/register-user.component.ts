import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { StudentService } from '../student.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
  preserveWhitespaces:true
})
export class RegisterUserComponent implements OnInit {

  userReg:FormGroup;

  constructor(private _userService:UserService,
              private _formBuilder:FormBuilder,
              private _router:Router
               )
   {

          this.userReg=this._formBuilder.group(

        {
         
        userName:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
        userEmail:['',Validators.compose([Validators.required,Validators.email])],
        userPassword:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
        
        
      }
      );
  }

  ngOnInit(): void {

  }
  uregister()
 { 
//alert("hello"); 
if(this.userReg.valid)

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
      this._userService.addUser(this.userReg.value).subscribe(response=>
        {
          Swal.fire('you are registered successfully', '', 'success')
          this._router.navigate(['/login']);
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
     
     console.log(this.userReg.valid);
 
      // this._userService.addUser(this.userReg.value).subscribe(response=>
      //  {
      //    console.log
      //   },
 
      //   (error=>
      //     {
      //       console.log(error);
      //     })
      //     );
       
       }
  
   console.log(this.userReg.value);
   //console.log(this.studentReg.value);
 
        }
        
}
