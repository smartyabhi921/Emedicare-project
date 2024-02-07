import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './model/student';
//import { User } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  
  private baseUrl="http://localhost:8080/"
  constructor(private _http:HttpClient) 
 
  { }

  public getAllStudent():Observable<Student[]>
  {

    return this._http.get<Student[]>(`${this.baseUrl}student/`);
  }

  public deleteStudent(studentIdl:number)
  {
    return this._http.delete(`${this.baseUrl}student/${studentIdl}`);
  }

  public  addStudent(studentRecord:Student):Observable<Student>

  {

      return this._http.post<Student>(`${this.baseUrl}student/`, studentRecord);

  }

  public getStudentById(studentIdl:number):Observable<Student>
  {
    
   return this._http.get<Student>(`${this.baseUrl}student/${studentIdl}`);
  
  }
  public updatestudentById(studentIdl:number,student:Student):Observable<Student>
  {
    
   return this._http.put<Student>(`${this.baseUrl}student/${studentIdl}`,student);
  
  }

}


