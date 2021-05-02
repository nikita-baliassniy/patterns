package ru.geekbrains.education;

import ru.geekbrains.education.mappers.LessonMapper;
import ru.geekbrains.education.model.Lesson;

public class Main {

    /**
     * Специально оставлял много дублирования и общих частей кода,
     * чтобы вычистить это в рамках 8 домашки по антипаттернам
     * */
    public static void main(String[] args) throws Exception {
        LessonMapper lessonMapper = new LessonMapper();
        Lesson l = lessonMapper.getLesson(1);
        System.out.println(l);

        Lesson l1 = lessonMapper.getLesson(1);
        l1.setSpecialisation("Music");

        System.out.println(l);
        System.out.println(l1);
    }
}
