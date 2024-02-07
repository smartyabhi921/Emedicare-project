import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  preserveWhitespaces:true,
})
export class LoginComponent implements OnInit 
{

    loginForm:FormGroup;

  constructor(private _formBuilder:FormBuilder ,
     private _userService:UserService,
     private _route:Router ) { }

  ngOnInit(): void
  {
    sessionStorage.removeItem('email');
    this.loginForm = this._formBuilder.group(

      {
          userEmail:['',Validators.compose([Validators.required,Validators.email])],
          userPassword:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
      }
    );
    
  }
  loginCheck()
  {
    if(this.loginForm.valid) 
    {
       var email= this.loginForm.get('userEmail')?.value;
       var password= this.loginForm.get('userPassword')?.value; 

       if((email=="admin@gmail.com"  && password=="admin"))
       {
        //alert("admin");
        sessionStorage.setItem('email',"admin");
        this._route.navigate(['admin']);
       }
       else
       {
        this._userService.checkLogin(email,password).subscribe(response=>
          {
               if(response!=null)
               {     
                     //alert("user");
                     sessionStorage.setItem('email',response.userEmail.toString());
                     this._route.navigate(['user-dashboard']);
                     }else
               {
                alert("WRONG USER NAME ? / PASSWORD ?/!");
               }
          },
          (error=>
           {
                   console.log(error);    
            } )
         )
  
      }
      console.log(this.loginForm.value);
     
       }
       
  }
}
