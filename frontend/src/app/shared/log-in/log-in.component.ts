import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from '../../service/authentication.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  private message: string;
  hide = true;
  logIn: FormGroup;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.logIn = new FormGroup( {
      email : new FormControl('', [Validators.required, Validators.email]),
      password : new FormControl('', Validators.required)
    });
  }


  getErrorMessage(): string {
    if (this.logIn.get('email').hasError('required')) {
      return 'You must enter a value';
    }
    this.message = this.logIn.get('email').hasError('email') ? 'Not a valid email' : '';
    return this.message;
  }

  onClickSendValues(): void {
    this.authenticationService.login(this.logIn.value.email, this.logIn.value.password).subscribe(
      (response) => {
        console.log(response.data, response.message, response.status );
    }, error => {
        console.log('Cannot log at the moment.');
      });
  }
}
