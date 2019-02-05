import { Component, OnInit } from '@angular/core';
import { CourseService } from '../service/course.service';
import { Course } from '../models/course';
import { numb } from '../models/numb';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courses: Course[];

  constructor(private courseService: CourseService) {}

  ngOnInit() {
    this.getCourses();
  }


  public removeCourse(course: Course) {
    console.log(course, 'remove');
    this.courseService.removeCourse(course).subscribe(res => {
      this.courses = this.courses.filter(el => el.getId() !== course.getId());
    });
  }
  private getCourses() {
    this.courseService.getAllCourses().subscribe(res => {
      this.courses = res;
    });
  }
}
