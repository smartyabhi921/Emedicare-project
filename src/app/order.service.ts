import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Order } from './model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  private baseUrl="http://localhost:8080/"
  constructor(private _http:HttpClient)

   { }

  public getAllOrderss():Observable<Order[]>
  {

    return this._http.get<Order[]>(`${this.baseUrl}order/`);
  }
  public  addOrders(studentRecord:Order):Observable<Order>

  {

      return this._http.post<Order>(`${this.baseUrl}order/`, studentRecord);

  }

  public deleteOrder(orderIdl:number)
  {
    return this._http.delete(`${this.baseUrl}order/${orderIdl}`);
 
 }

}
