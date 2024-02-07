import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl="http://localhost:8080/"
  constructor(private _http:HttpClient) 

  {}

  public getAllUsers():Observable<User[]>
  {

    return this._http.get<User[]>(`${this.baseUrl}users/`);
  }

  public checkLogin(email1:string,password1:string):Observable<User>

  {

    let httpParams = new HttpParams();

    httpParams=httpParams.append('email',email1);

    httpParams=httpParams.append('password',password1);

    return this._http.get<User>(`${this.baseUrl}users/check`,{params:httpParams});

  }

  public  addUser(studentRecord:User):Observable<User>

  {

      return this._http.post<User>(`${this.baseUrl}users/`, studentRecord);

  }

  public deleteUser(userId:number)
  {
    return this._http.delete(`${this.baseUrl}users/${userId}`);
 
 }

 public getUserById(userId:number)

{

return this._http.get<User>(`${this.baseUrl}users/${userId}`);

}
}


