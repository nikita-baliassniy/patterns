package ru.geekbrains.education.mappers;

import ru.geekbrains.education.identities.LessonIdentityMap;
import ru.geekbrains.education.model.Lesson;

import java.sql.*;

public class LessonMapper {
    public LessonMapper() {
    }

    public static Lesson getLesson(int key) throws Exception {
        Lesson lesson = LessonIdentityMap.isInto(key);
        if (lesson != null) {
            return lesson;
        } else {
            Lesson newLesson = findLessonById(key);
            LessonIdentityMap.add(newLesson);
            return newLesson;
        }
    }

    private static Lesson findLessonById(long id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                "root", "RootRoot1")) {
            Statement stat = conn.createStatement();
            String query = "select * from lessons where id = " + '\'' + id + '\'';
            ResultSet rs = stat.executeQuery(query);
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
