import { Speaker } from '../models/speaker';
export class Course {
    id: number;
  name: string;
  hour: number;
  speaker: Speaker;

  constructor(obj?: any) {
    this.id = (obj && obj.name) || '';
    this.name = (obj && obj.name) || '';
   this.hour = (obj && obj.name) || '';
}

  getId(): number {
    return this.id;
  }
  getName(): String {
    return this.name;
  }
}
