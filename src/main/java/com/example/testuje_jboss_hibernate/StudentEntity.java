package com.example.testuje_jboss_hibernate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class StudentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public StudentEntity(String name) {
        this.name = name;
    }
}
