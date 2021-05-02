package ru.geekbrains.education.mappers;

import ru.geekbrains.education.identities.ClientIdentityMap;
import ru.geekbrains.education.model.Client;

import java.sql.*;

public class ClientMapper {
    public ClientMapper() {
    }

    public static Client getClient(int key) throws Exception {
        Client client = ClientIdentityMap.isInto(key);
        if (client != null) {
            return client;
        } else {
            Client newClient = findClientById(key);
            ClientIdentityMap.add(newClient);
            return newClient;
        }
    }

    private static Client findClientById(long id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                "root", "RootRoot1")) {
            Statement stat = conn.createStatement();
            String query = "select * from clients where id = " + '\'' + id + '\'';
            ResultSet rs = stat.executeQuery(query);
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
