import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  readonly ROOT_URL = 'http://localhost:8080';
  studentId: number;

  constructor(private http: HttpClient) { }

  getStudentId(): number {
    return this.studentId;
  }
}
