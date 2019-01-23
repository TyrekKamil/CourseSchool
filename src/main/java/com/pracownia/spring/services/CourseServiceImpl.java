package com.pracownia.spring.services;

import com.pracownia.spring.entities.Course;
import com.pracownia.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository CourseRepository;

    @Override
    public Iterable<Course> listAllCourses() {
        return CourseRepository.findAll();
    }

    @Override
    public Course getCourseById(Integer id) {
        return CourseRepository.findOne(id);
    }

    @Override
    public Course saveCourse(Course Course) {
        return CourseRepository.save(Course);
    }

    @Override
    public void deleteCourse(Integer id) {
        CourseRepository.delete(id);
    }



}
