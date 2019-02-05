import { Course } from '../models/course';
export class Opinion {
  person_id: number;
    id: number;
  course: Course;
  text: string;

  constructor(obj?: any) {
    this.text = (obj && obj.name) || '';

}

  getId(): number {
    return this.id;
  }

}
