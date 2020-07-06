import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiResponse} from '../model/api-response';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  ROOT_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  id: number;

  findTeacherById(teacherId: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.ROOT_URL + '/teacher/' + this.id);
  }

  findAllStudents(): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.ROOT_URL + '/student/');
  }
}
