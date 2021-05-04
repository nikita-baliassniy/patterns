package ru.geekbrains.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends AbstractModel {
    private String fullName;
    private int age;
    private int experience;
    private double salary;
    private String specialisation;

    public Teacher(long id, String fullName, int age, int experience, double salary, String specialisation) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.specialisation = specialisation;
    }
}
