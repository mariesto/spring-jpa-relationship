package com.mariesto.springjparelationship.common.entity;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {

    private String id;
    private String name;
    private String gender;
    private Set<CourseDTO> enrolledCourse;

}
