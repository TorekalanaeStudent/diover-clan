package com.obedoza.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue
    private long id;
    private String fullName;
    private String course;

}
