package com.mariesto.springjparelationship.service;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Course;
import com.mariesto.springjparelationship.persistence.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public Collection<Course> findAllCourse(){
        return repository.findAll();
    }

    public Course findCourseById(int courseId) throws NotFoundException {
        return repository.findById(courseId)
                .orElseThrow(() -> new NotFoundException("Course Not Found with ID : " + courseId));
    }

    public void createCourse(Course course){
        repository.save(course);
    }

}
