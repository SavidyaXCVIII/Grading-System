import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from '../../service/authentication.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {Student} from '../../model/student';
import {TeacherService} from '../../service/teacher.service';
import {StudentService} from '../../service/student.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  private message: string;
  status: string;
  hide = true;
  logIn: FormGroup;

  constructor(private authenticationService: AuthenticationService,
              public dialogRef: MatDialogRef<LogInComponent>,
              @Inject(MAT_DIALOG_DATA) public type: string,
              private router: Router,
              private teacherService: TeacherService,
              private studentService: StudentService) {}

  ngOnInit(): void {
    // Creating Forms
    this.logIn = new FormGroup( {
      email : new FormControl('', [Validators.required, Validators.email]),
      password : new FormControl('', Validators.required)
    });
  }
  // Login Authentication
  getErrorMessage(): string {
    if (this.logIn.get('email').hasError('required')) {
      return 'You must enter a value';
    }
    this.message = this.logIn.get('email').hasError('email') ? 'Not a valid email' : '';
    return this.message;
  }

  // send the user details and authenticate and get the user specific id
  onClickSendValues(): void {
    this.authenticationService.login(this.logIn.value.email.toLowerCase(), this.logIn.value.password, this.type).subscribe(
      (response) => {
        this.status = response.message;
        console.log(response.message, response.status, response.data);
        if (response.status) {
          // const studentList: Student[] = response.data;
          this.dialogRef.close();
          if (this.type === 'Teacher'){
            this.router.navigate(['./teacher'], { skipLocationChange: true });
            // save the user specific id in the authenticate service
            this.teacherService.id = response.data;
            console.log(response.data);
          } else {
            // save the user specific id in the authenticate service
            this.studentService.studentId = response.data;
            this.router.navigate(['./student'], { skipLocationChange: true });
          }
        }
    }, error => {
        this.status = 'Cannot log at the moment.';
        console.log(error.toString());
      });
  }
}
