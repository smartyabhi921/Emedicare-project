import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  uid:any;
   user:User;

  constructor(private _userService:UserService) { }



  ngOnInit(): void

  {
    this.uid = sessionStorage.getItem('userId');

    alert(this.uid);

 this._userService.getUserById(this.uid).subscribe(response=>

      {
        this.user=response;
      },

      (error)=>
        {
      console.log(error);
        }
      );
      }
    }
