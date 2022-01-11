import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentInfo } from './student-info';


@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURLList ="http://localhost:3030/POC3/selectAll";
  private baseURLCreate ="http://localhost:3030/POC3/addUser";
  private baseURLGetById = "http://localhost:3030/POC3/getById";
  private baseURLUpdate = "http://localhost:3030/POC3/modify";
  private baseURLDelete = "http://localhost:3030/POC3/delete";
  private baseURLSearch = "http://localhost:3030/POC3/search";
  private baseURLSort = "http://localhost:3030/POC3/sortByField";
  



  constructor( private httpClient:HttpClient) { }

  getStudentList(): Observable<StudentInfo[]>{
    return this.httpClient.get<StudentInfo[]>(`${this.baseURLList}`);
  }

  createStudent(student: StudentInfo):Observable<Object>{
    return this.httpClient.post(`${this.baseURLCreate}`,student)
  }

  getStudentById(id: number):Observable<StudentInfo>{
    return this.httpClient.get<StudentInfo>(`${this.baseURLGetById}/${id}`)

  }

  updateStudent(id: number, student:StudentInfo):Observable<Object>{
    return this.httpClient.put(`${this.baseURLUpdate}/${id}`,student);
  }
  searchStudent(firstName: string, lastName:string,pinCode:number):Observable<Object>{
    let params = new HttpParams();
    params = params.append('firstName', firstName);
    params = params.append('lastName', lastName);
    params = params.append('pinCode', pinCode);
    return this.httpClient.get(`${this.baseURLSearch}`,{params:params});
  }

  sortStudent(field:string):Observable<Object>{
    return this.httpClient.get(`${this.baseURLSort}/${field}`); 
  }
  deleteStudent(id: number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURLDelete}/${id}`);
  }
}
