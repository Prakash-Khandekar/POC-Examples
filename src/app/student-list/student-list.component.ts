import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {StudentInfo} from '../student-info'
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: StudentInfo[]=[];

  constructor( private studentService: StudentService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getStudent();
  }
   private getStudent(){
    this.studentService.getStudentList().subscribe(data =>{
      console.log("Hii"+data.toString());
     this.students=data;
  },
  error => console.log(error));
}
updateStudent(id: number){
  this.router.navigate(['update-student',id]);
}
deleteStudent(id: number){
  this.studentService.deleteStudent(id).subscribe(data =>{
    console.log(data);
    this.getStudent();
  })
}
}
