package com.mariesto.springjparelationship.controller;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Course;
import com.mariesto.springjparelationship.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping("/")
    private ResponseEntity<Object> findAllCourse(){
        Collection<Course> allCourse = service.findAllCourse();

        return new ResponseEntity<>(allCourse, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    private ResponseEntity<Object> findCourseById(@PathVariable String courseId) throws NotFoundException {
        Course course = service.findCourseById(courseId);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<Object> createCourse(@RequestBody Course course){
        service.createCourse(course);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{courseId}/assign/{lecturerId}")
    private ResponseEntity<Object> assignCourse(@PathVariable String courseId, @PathVariable int lecturerId) throws NotFoundException {
        service.assignCourse(courseId, lecturerId);

        Course course = service.findCourseById(courseId);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
