package ru.geekbrains.education.mappers;

import ru.geekbrains.education.DBConnector;
import ru.geekbrains.education.model.Client;

import java.sql.*;

public class ClientMapper extends AbstractMapper<Client>{

    public ClientMapper() {
    }

    @Override
    protected Client findById(long id) {
        try {
            String query = "select * from clients where id = " + '\'' + id + '\'';
            ResultSet rs = DBConnector.getInstance().executeQuery(query);
            if (rs.next()) {
                String name = rs.getString("fullname");
                int age = rs.getInt("age");
                int gradation = rs.getInt("gradation");
                double staticDiscount = rs.getDouble("static_discount");
                return new Client(id, name, age, gradation, staticDiscount);
            } else {
                System.out.println("Record not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
} 
