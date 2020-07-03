import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  readonly ROOT_URL = 'http://localhost:8080';
  private message: string;
  hide = true;
  logIn: FormGroup;

  constructor(private httpClient: HttpClient) { }

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
    // tslint:disable-next-line:max-line-length
    this.httpClient.post( this.ROOT_URL + '/userAuthenticate?email=' + this.logIn.value.email + '&password=' + this.logIn.value.password, null).subscribe((value => {
    }));
  }
}
