package com.mariesto.springjparelationship.service;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Student;
import com.mariesto.springjparelationship.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

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

}
