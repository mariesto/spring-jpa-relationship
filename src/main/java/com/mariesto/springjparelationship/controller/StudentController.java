package com.mariesto.springjparelationship.controller;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Student;
import com.mariesto.springjparelationship.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
@RestController
public class StudentController {

    private final StudentService service;

    @GetMapping("/")
    private ResponseEntity<Object> findAllStudent(){
        Collection<Student> allStudents = service.findAllStudents();

        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    private ResponseEntity<Object> findStudentById(@PathVariable String studentId) throws NotFoundException {
        Student student = service.findStudentById(studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<Object> createStudent(@RequestBody Student student){
        service.createStudent(student);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
