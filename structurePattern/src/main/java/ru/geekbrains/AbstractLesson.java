package ru.geekbrains;

import java.util.Date;

abstract class AbstractLesson implements Lesson {
    private String teacher;
    private Date dateOfPerform;
    private String topic;
    private String status;
    private double duration;
    private int grade;

    @Override
    public String getTeacher() {
        return teacher;
    }

    @Override
    public Date getDateOfPerform() {
        return dateOfPerform;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public int getGrade() {
        return grade;
    }

    @Override
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public void setDateOfPerform(Date dateOfPerform) {
        this.dateOfPerform = dateOfPerform;
    }

    @Override
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public void close() {
        this.status = "Finished";
    }

    @Override
    public void cancelLesson() {
        this.status = "Cancelled";
    }

    @Override
    public void startLesson() {
        this.status = "Started";
    }
}
