import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SelectUserComponent} from './select-user/select-user.component';
import {StudentDashboardComponent} from './student-dashboard/student-dashboard.component';
import {TeacherDashboardComponent} from './teacher-dashboard/teacher-dashboard.component';


const routes: Routes = [
  {
    path: '',
    component: SelectUserComponent
  },
  {
    path: 'student',
    component: StudentDashboardComponent
  },
  {
    path: 'teacher',
    component: TeacherDashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
