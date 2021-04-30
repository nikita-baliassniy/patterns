package ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Курс обучения выступает в роли компоновщика для различных изучаемых дисциплин
 */
public class Course extends AbstractLesson {
    protected List<Lesson> children = new ArrayList<>();

    public Course(Lesson... lessons) {
        super();
        add(lessons);
    }

    private void add(Lesson... lessons) {
        children.addAll(Arrays.asList(lessons));
    }

    public void add(Lesson lesson) {
        children.add(lesson);
    }

    public void remove(Lesson lesson) {
        children.remove(lesson);
    }

    public void clear() {
        children.clear();
    }

    @Override
    public double getDuration() {
        double generalDuration = 0;
        for (Lesson lesson : children) {
            generalDuration += lesson.getDuration();
        }
        return generalDuration;
    }

    @Override
    public String getTeacher() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lesson lesson : children) {
            stringBuilder.append(lesson.getTeacher());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public void close() {
        for (Lesson lesson : children) {
            if (!lesson.getStatus().equals("Closed")) {
                lesson.close();
            }
        }
    }
}
