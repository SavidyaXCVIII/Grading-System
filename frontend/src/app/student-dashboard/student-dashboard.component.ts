import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';
import {Student} from '../model/student';
import {Assignment} from '../model/assignment';
import {Question} from '../model/question';
import {StudentService} from '../service/student.service';

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
  assignmentIndex: number;
  questions: Question[];

  constructor(private authenticationService: AuthenticationService,
              private studentService: StudentService) {}

  ngOnInit(): void {
    // get user id from the authentication service
    this.studentId = this.studentService.getStudentId();
    console.log(this.studentId);
    // get student object by sending student id
    this.studentService.findStudentById(this.studentId).subscribe((response) => {
      this.student = response.data;
      this.assignments = this.student.assignments;
      this.course = this.assignments[0].course;
    });
  }

  getAssignmentName(index: number): void {
    this.assignmentIndex = index;
    this.questions = this.assignments[this.assignmentIndex].questions;
  }

  scroll(el: HTMLElement): void {
    setTimeout(() => {
      el.scrollIntoView(
        {behavior: 'smooth'}
      );
    }, 200);
  }

  logOut(): void {
    this.studentService.studentId = null;
  }
}
