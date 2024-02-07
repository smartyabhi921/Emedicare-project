import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Student } from '../model/student';
import { User } from '../model/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css'],
  preserveWhitespaces:true
})
export class ViewUserComponent implements OnInit {

  userList:User[]=[];

  constructor(private _userService:UserService) { }

  ngOnInit(): void 
  {
    this.getAllUsersD();
  }

  getAllUsersD()
  {
    this._userService.getAllUsers().subscribe((response:User[])=>
    {
       
        this.userList=response;
    },
    (error=>
      {
        console.log(error);
      }
      
    )
  );
  }
  deleteUser(id:number)

  {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: "You want to Remove this user!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, Remove USER!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
  
        this._userService.deleteUser(id).subscribe(response=>
          {
             
              this.getAllUsersD();
              swalWithBootstrapButtons.fire(
                'Deleted!',
                'User has been deleted.',
                'success'
              )
          },(error=>
            {
              console.log(error);
            }
            
          )
        );
  
  
  
        
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'User Data is safe :)',
          'error'
        )
      }
    });
  
}
}