package ru.geekbrains.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    private Long id;
    private String specialisation;
    private String topic;
    private int duration;
    private long teacher;
    private long client;
}
