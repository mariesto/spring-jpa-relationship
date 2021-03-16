package com.mariesto.springjparelationship.service;

import com.mariesto.springjparelationship.common.NotFoundException;
import com.mariesto.springjparelationship.persistence.entity.Lecturer;
import com.mariesto.springjparelationship.persistence.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class LecturerService {

    private final LecturerRepository repository;

    public Collection<Lecturer> findAllLecturer(){
        return repository.findAll();
    }

    public Lecturer findLecturerById(int lecturerId) throws NotFoundException {
        return repository.findById(lecturerId)
                .orElseThrow(() -> new NotFoundException("Lecturer Not Found with ID : " + lecturerId));
    }

    public void createLecturer(Lecturer lecturer){
        repository.save(lecturer);
    }

}
