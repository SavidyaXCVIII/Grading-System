import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent implements OnInit {

  userEmail = this.authenticationService.getUserEmail();
  student = this.authenticationService.getStudent();

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

}
