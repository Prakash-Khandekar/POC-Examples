import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';
import { SearchStudentComponent } from './search-student/search-student.component';
import { SortStudentComponent } from './sort-student/sort-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
  {
    path:'students',component:StudentListComponent
  },
  {
    path:'create-student',component:CreateStudentComponent
  },
  {
    path:'',redirectTo:'students',pathMatch:'full'
  },
  {
    path:'update-student/:id',component: UpdateStudentComponent
  },
  {
    path:'search-student',component:SearchStudentComponent
  },
  {
    path:'sort-student',component:SortStudentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
