package com.mariesto.springjparelationship.persistence.repository;

import com.mariesto.springjparelationship.persistence.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
