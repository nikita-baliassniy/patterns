package ru.geekbrains.education.mappers;

import ru.geekbrains.education.identities.LessonIdentityMap;
import ru.geekbrains.education.identities.TeacherIdentityMap;
import ru.geekbrains.education.model.Lesson;
import ru.geekbrains.education.model.Teacher;

import java.sql.*;

public class TeacherMapper {
    public TeacherMapper() {
    }

    public static Teacher getTeacher(int key) throws Exception {
        Teacher teacher = TeacherIdentityMap.isInto(key);
        if (teacher != null) {
            return teacher;
        } else {
            Teacher newTeacher = findTeacherById(key);
            TeacherIdentityMap.add(newTeacher);
            return newTeacher;
        }
    }

    private static Teacher findTeacherById(long id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                "root", "RootRoot1")) {
            Statement stat = conn.createStatement();
            String query = "select * from teachers where id = " + '\'' + id + '\'';
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                String fullName = rs.getString("fullname");
                String specialisation = rs.getString("specialisation");
                double salary = rs.getDouble("salary");
                int age = rs.getInt("age");
                int experience = rs.getInt("experience");
                return new Teacher(id, fullName, age, experience, salary, specialisation);
            } else {
                System.out.println("Record not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
