package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        MathLesson mathLesson = new MathLesson();
        mathLesson.setDuration(100);
        HistoryLesson historyLesson = new HistoryLesson();
        historyLesson.setDuration(200);
        EnglishLesson englishLesson = new EnglishLesson();
        englishLesson.setDuration(150);

        Course course = new Course(mathLesson, historyLesson, englishLesson);
        System.out.println(course.getDuration());
    }
}
