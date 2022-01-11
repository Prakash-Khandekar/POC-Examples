import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentInfo } from '../student-info';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  id!: number;
student: StudentInfo =new StudentInfo();
  constructor( private studentService:StudentService,
    private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe(data =>{
      this.student = data;
    },
    error => console.log(error)); 
  }
  onSubmit(){
    this.studentService.updateStudent(this.id, this.student).subscribe( data => {
      this.goToStudentList();
    },
    error => console.log(error)); 
    }
  goToStudentList(){
    this.router.navigate(['/students']);
   }
 
}
