package ru.geekbrains.education.mappers;

import ru.geekbrains.education.DBConnector;
import ru.geekbrains.education.model.Lesson;

import java.sql.*;

public class LessonMapper extends AbstractMapper<Lesson> {

    public LessonMapper() {
    }

    @Override
    protected Lesson findById(long id) {
        try {
            String query = "select * from lessons where id = " + '\'' + id + '\'';
            ResultSet rs = DBConnector.getInstance().executeQuery(query);
            if (rs.next()) {
                String specialisation = rs.getString("specialisation");
                String topic = rs.getString("topic");
                long teacher = rs.getLong("teacher");
                long client = rs.getLong("client");
                int duration = rs.getInt("duration");
                return new Lesson(id, specialisation, topic, duration, teacher, client);
            } else {
                System.out.println("Record not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
