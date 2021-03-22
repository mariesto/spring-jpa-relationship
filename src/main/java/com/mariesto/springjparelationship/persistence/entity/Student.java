package com.mariesto.springjparelationship.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Student {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "code")
    )
    private Set<Course> enrolledCourse;

}
