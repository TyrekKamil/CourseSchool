import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-course-item',
  templateUrl: './course-item.component.html',
  styleUrls: ['./course-item.component.css']
})
export class CourseItemComponent implements OnInit {
  @Input() course: Course;
  @Output() removeItem: EventEmitter<Course> = new EventEmitter();
  constructor(private courseService: CourseService) {}

  ngOnInit() {}

  remove() {
    this.removeItem.emit(this.course);
  }


}
