import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

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

}
