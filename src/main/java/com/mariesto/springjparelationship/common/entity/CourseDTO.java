package com.mariesto.springjparelationship.common.entity;

import com.mariesto.springjparelationship.persistence.entity.Lecturer;
import lombok.Data;

@Data
public class CourseDTO {

    private String code;
    private String name;
    private String description;
    private Lecturer lecturer;

}
