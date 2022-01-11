import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentInfo } from '../student-info';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {
 student:StudentInfo = new StudentInfo();
  constructor(private studentService:StudentService,
    private router:Router) { }

  ngOnInit(): void {
  }

  saveStudent(){
    this.studentService.createStudent(this.student).subscribe( data =>{
      console.log(data);
      this.goToStudentList();
    },
    error => console.log(error)
    );
    
  }
  goToStudentList(){
   this.router.navigate(['/students']);
  }
  onSubmit(){
    console.log(this.student)
    this.saveStudent();
  }

}
