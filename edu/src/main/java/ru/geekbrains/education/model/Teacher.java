package ru.geekbrains.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Long id;
    private String fullName;
    private int age;
    private int experience;
    private double salary;
    private String specialisation;
}
