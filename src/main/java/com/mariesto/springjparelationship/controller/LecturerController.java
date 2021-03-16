package com.mariesto.springjparelationship.controller;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Lecturer;
import com.mariesto.springjparelationship.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/lecturers")
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerService service;

    @GetMapping("/")
    private ResponseEntity<Object> findAllLecturer(){
        Collection<Lecturer> allLecturer = service.findAllLecturer();

        return new ResponseEntity<>(allLecturer, HttpStatus.OK);
    }

    @GetMapping("/{lecturerId}")
    private ResponseEntity<Object> findLecturerById(@PathVariable int lecturerId) throws NotFoundException {
        Lecturer lecturer = service.findLecturerById(lecturerId);

        return new ResponseEntity<>(lecturer, HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<Object> createLecturer(@RequestBody Lecturer lecturer){
        service.createLecturer(lecturer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
