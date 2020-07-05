import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';
import {Student} from '../model/student';
import {Assignment} from '../model/assignment';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent implements OnInit {

  studentId: number;
  course: string;
  panelOpenState: boolean;
  student: Student;
  assignments: Assignment[];

  constructor(private authenticationService: AuthenticationService) {}

  ngOnInit(): void {
    this.studentId = this.authenticationService.getStudentId();
    console.log(this.studentId);
    this.authenticationService.findStudentById(this.studentId).subscribe((response) => {
      this.student = response.data;
      this.assignments = this.student.assignments;
      this.course = this.assignments[0].course;
    });
  }

}
