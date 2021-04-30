package ru.geekbrains;

import java.util.Date;

public interface Lesson {
    String getTeacher();

    Date getDateOfPerform();

    String getTopic();

    double getDuration();

    String getStatus();

    int getGrade();

    void setTeacher(String teacher);

    void setTopic(String topic);

    void setDateOfPerform(Date dateOfPerform);

    void setDuration(double duration);

    void setStatus(String status);

    void setGrade(int grade);

    void close();

    void cancelLesson();

    void startLesson();
}
