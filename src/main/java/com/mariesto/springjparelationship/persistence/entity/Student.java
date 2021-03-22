package com.mariesto.springjparelationship.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

}
