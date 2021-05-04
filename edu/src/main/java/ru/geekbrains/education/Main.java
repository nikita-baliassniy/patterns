package ru.geekbrains.education;

import ru.geekbrains.education.mappers.LessonMapper;
import ru.geekbrains.education.model.Lesson;

public class Main {

    public static void main(String[] args) {
        LessonMapper lessonMapper = new LessonMapper();
        Lesson l = lessonMapper.getObject(1);
        System.out.println(l);

        Lesson l1 = lessonMapper.getObject(1);
        l1.setSpecialisation("Music");

        System.out.println(l);
        System.out.println(l1);
    }
}
