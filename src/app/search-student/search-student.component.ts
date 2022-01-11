import { Component, OnInit } from '@angular/core';
import { StudentInfo } from '../student-info';
import { StudentService } from '../student.service';
 import { Router } from '@angular/router';
 
@Component({
  selector: 'app-search-student',
  templateUrl: './search-student.component.html',
  styleUrls: ['./search-student.component.css']
})
export class SearchStudentComponent implements OnInit {
  students: StudentInfo[]=[];
  constructor(private studentService:StudentService) { }

  ngOnInit(): void {
  }

  showText(firstName: any,lastName: any,pinCode: any){
    console.log(firstName+lastName+pinCode);
    this.studentService.searchStudent(firstName,lastName,pinCode).subscribe( (data: any ) => {
      this.students=data;
    },
    error => console.log(error)); 
  }

}
