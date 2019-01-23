package com.pracownia.spring.services;


import com.pracownia.spring.entities.Course;



public interface CourseService {

    Iterable<Course> listAllCourses();

    Course getCourseById(Integer id);

    Course saveCourse(Course Course);

    void deleteCourse(Integer id);


}
