import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiResponse} from '../model/api-response';
import {Student} from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  readonly ROOT_URL = 'http://localhost:8080';
  userEmail: string;

  constructor(private http: HttpClient) { }

  login(email: string, password: string, type: string): Observable<ApiResponse> {

    const httpOptions = {
      headers: new HttpHeaders( {}),
      params: new HttpParams({
        fromObject: {
          email,
          password,
          type
        }
      })
    };

    return  this.http.post<ApiResponse>( this.ROOT_URL + '/authentication/login?email=' +
      email + '&password=' + password + '&type=' + type,
      null);
  }

  getUserEmail(): string {
    return this.userEmail;
  }

  getStudent(): Observable<Student> {
    return this.http.get<Student>(this.ROOT_URL + '/student?email=' + this.userEmail);
  }
}
