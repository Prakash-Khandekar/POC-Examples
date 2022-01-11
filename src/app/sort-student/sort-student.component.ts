import { Component, OnInit } from '@angular/core';
import { StudentInfo } from '../student-info';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-sort-student',
  templateUrl: './sort-student.component.html',
  styleUrls: ['./sort-student.component.css']
})
export class SortStudentComponent implements OnInit {
   students:StudentInfo[]=[];
  constructor(private studentService:StudentService) { }

  ngOnInit(): void {
  }

  selectedField: string = '';

  //event handler for the select element's change event
  selectChangeHandler (event: any) {
    this.selectedField = event.target.value;
    console.log(this.selectedField);

    this.studentService.sortStudent(this.selectedField).subscribe( (data: any ) => {
      this.students=data;
    },
    error => console.log(error)); 
  }
  }


