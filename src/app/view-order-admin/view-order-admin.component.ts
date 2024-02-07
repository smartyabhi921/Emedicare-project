import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Order } from '../model/order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-view-order-admin',
  templateUrl: './view-order-admin.component.html',
  styleUrls: ['./view-order-admin.component.css'],
  preserveWhitespaces:true
})
export class ViewOrderAdminComponent implements OnInit {
[x: string]: any;

  orderList:Order[]=[];
  
  constructor(private _orderService:OrderService) 
  { }

  ngOnInit(): void 
  
  {
    this.getAllOrderDetails();
  }
  getAllOrderDetails()
  {
    this._orderService.getAllOrderss().subscribe((response:Order[])=>
    {
       
        this.orderList=response;
    },(error=>
      {
        console.log(error);
      }
      
    )
  );
    }
  deleteOrder(id:number)

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
      text: "You Sure wana Confirm This Order As Completed",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, confirm and delete!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
  
        this._orderService.deleteOrder(id).subscribe(response=>
          {
             
              this.getAllOrderDetails();
              swalWithBootstrapButtons.fire(
                'Done!',
                'Order Have been fullfilled',
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
          'Your Order is back To normal :)',
          'error'
        )
      }
    });
  
  }
  
  
  }
