package ru.geekbrains.education;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Общая часть по работе с бд выделена в отдельный класс
 * */
public class DBConnector {

    private static DBConnector instance;
    private static Connection connection;

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    private DBConnector() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String host = resourceBundle.getString("host");
        String port = resourceBundle.getString("port");
        String db = resourceBundle.getString("db");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");
        String jdbcURL = MessageFormat.format("jdbc:mysql://{0}:{1}/{2}", host, port, db);
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

}
