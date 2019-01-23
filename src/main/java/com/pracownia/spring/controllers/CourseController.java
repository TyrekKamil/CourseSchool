package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Course;
import com.pracownia.spring.services.PersonService;
import com.pracownia.spring.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService CourseService;

    @RequestMapping(value = "/Courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Course> list(Model model) {
        return CourseService.listAllCourses();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/Courses", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Course> redirect(Model model) {
        return CourseService.listAllCourses();
    }

    @RequestMapping(value = "/Course/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public Course getByPublicId(@PathVariable("id") Integer publicId) {
        return CourseService.getCourseById(publicId);
    }

    @RequestMapping(value = "/Course", method = RequestMethod.POST)
    public ResponseEntity<Course> create(@RequestBody @Valid @NotNull Course Course) {
        CourseService.saveCourse(Course);
        return ResponseEntity.ok().body(Course);
    }

    @RequestMapping(value = "/Course", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Course Course) {
        Course CourseFromData = CourseService.getCourseById(Course.getId());
        if(Objects.nonNull(CourseFromData)) {
            CourseService.saveCourse(Course);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/Course/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        CourseService.deleteCourse(id);
        return new RedirectView("/api/Courses", true);
    }



}
