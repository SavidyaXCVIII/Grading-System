import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-teacher-dashboard',
  templateUrl: './teacher-dashboard.component.html',
  styleUrls: ['./teacher-dashboard.component.css']
})
export class TeacherDashboardComponent implements OnInit {

  userEmail: string;
  teacher: any;
  course: string;
  panelOpenState: boolean;

  constructor(private authenticationService: AuthenticationService) {
    // this.userEmail = this.authenticationService.get();
    this.authenticationService.getTeacher(this.userEmail).subscribe((response) => {
      this.teacher = response;
    });
  }

  ngOnInit(): void {
  }

}
