import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';
import {TeacherService} from '../service/teacher.service';
import {Teacher} from '../model/teacher';
import {Student} from '../model/student';
import {Assignment} from '../model/assignment';
import {Question} from '../model/question';
import {ifStmt} from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-teacher-dashboard',
  templateUrl: './teacher-dashboard.component.html',
  styleUrls: ['./teacher-dashboard.component.css']
})
export class TeacherDashboardComponent implements OnInit {

  teacherId: number;
  teacher: Teacher;
  course: string;
  students: Student[];
  assignments: string[] = ['Object Oriented Programming', 'Algorithms', 'Database Systems'];
  questions: Question[];
  totalTime: number;
  assignmentNumber: number;
  assignmentQuestions: Question[];
  count: number;

  constructor(private teacherService: TeacherService) {}


  ngOnInit(): void {
    this.teacherService.findTeacherById(this.teacherId).subscribe((response) => {
      this.teacher = response.data;
    });

    this.teacherService.findAllStudents().subscribe((response) => {
      this.students = response.data;
      this.questions = response.data[0].assignments[0].questions;
    });
  }

  getAssignmentNumber(assignmentNumber: number): void {
    this.assignmentNumber = assignmentNumber;
  }

  findAverageTimeOnQuestion(questionNumber: number, assignment: number): number {
    this.totalTime = 0;
    this.students.forEach(x => this.totalTime = this.totalTime + x.assignments[assignment].questions[questionNumber].timeSpent);
    return this.totalTime / this.students.length;
  }

  findNumberOfStudentAnsweredCorrect(questionNumber: number, assignment: number): void {
    this.students.forEach(x => {
    });
  }

  scroll(el: HTMLElement): void {
    setTimeout(() => {
      el.scrollIntoView(
        {behavior: 'smooth'}
      );
    }, 200);
  }

  findQuestionsByAssignment(assignmentNumber: number): void {
    console.log(this.students[0].assignments[assignmentNumber].questions);
    this.assignmentQuestions = this.students[0].assignments[assignmentNumber].questions;
  }


}
