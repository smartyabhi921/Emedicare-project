import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css'],
  preserveWhitespaces:true
})
export class AddOrderComponent implements OnInit {

  addOrder:FormGroup;

  constructor(private _orderService:OrderService,
              private _formBuilder:FormBuilder,
              private _router:Router
               )
   {

          this.addOrder=this._formBuilder.group(

        {
         orderIdl:[0], 
         orderName:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
        orderEmail:['',Validators.compose([Validators.required,Validators.email])],
        orderPassword:['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
         orderAge:['',Validators.compose([Validators.required,Validators.min(1),Validators.max(30)])],  
        orderClass:['',Validators.compose([Validators.required,Validators.minLength(2),Validators.maxLength(10)])], 
        
      }
      );
  }

  ngOnInit(): void {

  }
  register()
 { 
//alert("hello"); 
if(this.addOrder.valid)

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
      this._orderService.addOrders(this.addOrder.value).subscribe(response=>
        {
          Swal.fire('your record is saved', '', 'success')
          this._router.navigate(['/user-dashboard']);
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
     
     console.log(this.addOrder.valid);
    } 
        }
}
