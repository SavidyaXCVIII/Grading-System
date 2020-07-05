import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiResponse} from '../model/api-response';
import {Student} from '../model/student';
import {Teacher} from '../model/teacher';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  readonly ROOT_URL = 'http://localhost:8080';
  studentId: number;

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

    return  this.http.post<ApiResponse>( this.ROOT_URL + '/authentication/login',
      null, httpOptions);
  }

  getStudentId(): number {
    return this.studentId;
  }

  findStudentById(studentId: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.ROOT_URL + '/student/' + studentId);
  }

  getTeacher(userEmail: string): Observable<Teacher> {
    return this.http.get<Teacher>(this.ROOT_URL + '/teacher?email=' + userEmail);
  }
}
