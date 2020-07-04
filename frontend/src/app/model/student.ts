import {Assignment} from './assignment';

export class Student {
  studentId: number;
  studentName: string;
  email: string;
  password: string;
  assignments: Assignment[];
}
