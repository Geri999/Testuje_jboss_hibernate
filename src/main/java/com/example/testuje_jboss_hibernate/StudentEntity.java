package com.example.testuje_jboss_hibernate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "STUDENTS")
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public StudentEntity(String name) {
        this.name = name;
    }
}
