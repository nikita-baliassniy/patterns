package ru.geekbrains.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractModel {
    private String fullName;
    private int age;
    private int gradation;
    private double staticDiscount;

    public Client(Long id, String fullName, int age, int gradation, double staticDiscount) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gradation = gradation;
        this.staticDiscount = staticDiscount;
    }
}
