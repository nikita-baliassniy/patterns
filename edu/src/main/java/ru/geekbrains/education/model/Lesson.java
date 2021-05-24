package ru.geekbrains.education.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Lesson extends AbstractModel {
    private String specialisation;
    private String topic;
    private int duration;
    private long teacher;
    private long client;

    public Lesson(long id, String specialisation, String topic, int duration, long teacher, long client) {
        this.id = id;
        this.specialisation = specialisation;
        this.topic = topic;
        this.duration = duration;
        this.teacher = teacher;
        this.client = client;
    }
}
