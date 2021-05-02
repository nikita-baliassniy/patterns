package ru.geekbrains.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long id;
    private String fullName;
    private int age;
    private int gradation;
    private double staticDiscount;
}
