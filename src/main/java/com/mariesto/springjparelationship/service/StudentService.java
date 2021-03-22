package com.mariesto.springjparelationship.service;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Course;
import com.mariesto.springjparelationship.persistence.entity.Student;
import com.mariesto.springjparelationship.persistence.repository.CourseRepository;
import com.mariesto.springjparelationship.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;
    private final CourseRepository courseRepository;

    public Collection<Student> findAllStudents(){
        return repository.findAll();
    }

    public Student findStudentById(String id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student Not Found with ID : " + id));
    }

    public void createStudent(Student student){
        repository.save(student);
    }

    @Transactional
    public void enrollCourse(String courseId, String studentId){
        repository.findById(studentId)
                .map(student -> {
                    Optional<Course> course = courseRepository.findById(courseId);

                    student.getEnrolledCourse().add(course.get());
                    return repository.save(student);
                });
    }

}
