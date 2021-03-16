package com.mariesto.springjparelationship.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mariesto.springjparelationship.persistence.entity.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
}
