import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from '../../service/authentication.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit, OnDestroy {

  private message: string;
  hide = true;
  logIn: FormGroup;
  status = false;

  constructor(private authenticationService: AuthenticationService,
              public dialogRef: MatDialogRef<LogInComponent>,
              @Inject(MAT_DIALOG_DATA) public type: string,
              private router: Router) {}

  ngOnInit(): void {
    this.logIn = new FormGroup( {
      email : new FormControl('', [Validators.required, Validators.email]),
      password : new FormControl('', Validators.required)
    });
  }

  ngOnDestroy(): void {
    this.authenticationService.userEmail = this.logIn.value.email;
  }


  getErrorMessage(): string {
    if (this.logIn.get('email').hasError('required')) {
      return 'You must enter a value';
    }
    this.message = this.logIn.get('email').hasError('email') ? 'Not a valid email' : '';
    return this.message;
  }

  onClickSendValues(): void {
    this.authenticationService.login(this.logIn.value.email, this.logIn.value.password, this.type).subscribe(
      (response) => {
        console.log(response.message, response.status );
        if (response.status) {
          if (this.type === 'Teacher'){
            this.router.navigate(['./teacher'], { skipLocationChange: true });
          } else {
            this.router.navigate(['./student'], { skipLocationChange: true });
          }
          this.dialogRef.close();
        }
    }, error => {
        console.log('Cannot log at the moment.');
      });
  }
}
