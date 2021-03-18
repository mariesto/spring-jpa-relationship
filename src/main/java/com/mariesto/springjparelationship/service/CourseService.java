package com.mariesto.springjparelationship.service;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Course;
import com.mariesto.springjparelationship.persistence.entity.Lecturer;
import com.mariesto.springjparelationship.persistence.repository.CourseRepository;
import com.mariesto.springjparelationship.persistence.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final LecturerRepository lecturerRepository;

    public Collection<Course> findAllCourse(){
        return repository.findAll();
    }

    public Course findCourseById(String courseId) throws NotFoundException {
        return repository.findById(courseId)
                .orElseThrow(() -> new NotFoundException("Course Not Found with ID : " + courseId));
    }

    public void createCourse(Course course){
        repository.save(course);
    }

    @Transactional
    public void assignCourse(String courseId, int lecturerId){
        repository.findById(courseId)
                .map(course -> {
                    Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);

                    course.setLecturer(lecturer.get());
                    return repository.save(course);
                });
    }

}
