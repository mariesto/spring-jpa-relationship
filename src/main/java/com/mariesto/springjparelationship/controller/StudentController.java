package com.mariesto.springjparelationship.controller;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.common.entity.StudentDTO;
import com.mariesto.springjparelationship.persistence.entity.Student;
import com.mariesto.springjparelationship.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
@RestController
public class StudentController {

    private final StudentService service;

    @Autowired
    private final ModelMapper modelMapper;

    @GetMapping("/")
    private ResponseEntity<Object> findAllStudent(){
        Collection<Student> allStudents = service.findAllStudents();

        List<StudentDTO> studentDTOS = allStudents.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
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

    @PatchMapping("/{studentId}/enroll/{courseId}")
    private ResponseEntity<Object> enrollCourse(@PathVariable String studentId, @PathVariable String courseId) throws NotFoundException {
        service.enrollCourse(courseId, studentId);

        Student student = service.findStudentById(studentId);
        StudentDTO studentDTO = convertToDTO(student);

        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    private StudentDTO convertToDTO(Student student){
        return modelMapper.map(student, StudentDTO.class);
    }

}
