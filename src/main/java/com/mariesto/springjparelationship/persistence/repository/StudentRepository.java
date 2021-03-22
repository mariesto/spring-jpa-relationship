package com.mariesto.springjparelationship.persistence.repository;

import com.mariesto.springjparelationship.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
