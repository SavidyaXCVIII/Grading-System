import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiResponse} from '../model/api-response';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  readonly ROOT_URL = 'http://localhost:8080';
  studentId: number;

  constructor(private http: HttpClient) { }

  findStudentById(studentId: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.ROOT_URL + '/student/' + studentId);
  }

  getStudentId(): number {
    return this.studentId;
  }
}
