package ru.geekbrains.education.mappers;

import ru.geekbrains.education.DBConnector;
import ru.geekbrains.education.model.Teacher;

import java.sql.*;

public class TeacherMapper extends AbstractMapper<Teacher>{

    public TeacherMapper() {
    }

    @Override
    protected Teacher findById(long id) {
        try {
            String query = "select * from teachers where id = " + '\'' + id + '\'';
            ResultSet rs = DBConnector.getInstance().executeQuery(query);
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
