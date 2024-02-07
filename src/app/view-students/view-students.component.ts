import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Student } from '../model/student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.css']
})
export class ViewStudentsComponent implements OnInit {


  studentList:Student[]=[];

  constructor(private _studentService:StudentService) { }

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
deleteStudent(id:number)

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
    text: "You won't be able to revert this!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Yes, delete it!',
    cancelButtonText: 'No, cancel!',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {

      this._studentService.deleteStudent(id).subscribe(response=>
        {
           
            this.getAllStudentDetails();
            swalWithBootstrapButtons.fire(
              'Deleted!',
              'Your file has been deleted.',
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
        'Your file is safe :)',
        'error'
      )
    }
  });

}


}


