import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {


  private message: string;
  hide = true;
  logIn: FormGroup;

  constructor() { }

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

  onClickSendValues() {
  }
}
