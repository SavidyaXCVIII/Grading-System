import {Question} from './question';

export class Assignment {
  assignmentName: string;
  numberOfQuestions: number;
  numberOfAttempts: number;
  questions: Question[];
  course: string;
}
