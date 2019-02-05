import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const apiUrl: String = 'http://localhost:8080/spring-1.0-SNAPSHOT/';

@Injectable()
export class CourseService {
  constructor(private http: HttpClient) {}

  getAllCourses(): Observable<any> {
    return this.http.get(`${apiUrl}/api/Courses`);
  }

  getHowManyPosen(): Observable<any>
{
return this.http.get('${apiUrl}/api/Address/howMany');
}

  createNewCourse(person: any): Observable<any> {
   let result: Observable<Object>;
    if (person['href']) {
      result = this.http.put(`${apiUrl}/api/Person`, person);
    } else {
      result = this.http.post(`${apiUrl}/api/Person`, person);
    }
    return result;
  }
  removeCourse(Course: Course) {
    return this.http.delete(`${apiUrl}/api/Person/${Course.getId()}`);
  }

  updateCourse(Course: Course) {
    return this.http.put(`${apiUrl}/api/Person/${Course.getId()}`, Course);
  }
}
