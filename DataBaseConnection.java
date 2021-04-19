package ru.aplana.autotests.db;


import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nsd on 02.02.2018.
 */

@Slf4j
public class DataBaseConnection {

    private static Connection con;
    private static DataBaseConnection instance = null;
    private static IDBConfig currentConfig = null;

    private DataBaseConnection(IDBConfig config) {
        currentConfig = config;
        String login = currentConfig.getLogin();
        String password = currentConfig.getPassword();
        String url = currentConfig.getUrl();
        try {
            Class.forName(currentConfig.getJDBCDriver());
            DriverManager.setLoginTimeout(20);
            con = DriverManager.getConnection(url, login, password);
        } catch (SQLRecoverableException e) {
            e.printStackTrace();
            waitDb(5000);
            try {
                con = DriverManager.getConnection(url, login, password);
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new AssertionError(String.format("Не удалось подключиться к Базе: [%s] login: [%s]. Получена ошибка [%s]", url, login, e1.getMessage()));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new AssertionError(String.format("Не удалось подключиться к Базе: [%s] login: [%s]. Получена ошибка [%s]", url, login, e.getMessage()));
        }
    }

    private void waitDb(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static DataBaseConnection getInstance(IDBConfig config) {
        if (instance == null || !config.getUrl().equals(currentConfig.getUrl())) {
            closeConnections();
            instance = new DataBaseConnection(config);
        }
        return instance;
    }

    public static void closeConnections() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
            instance = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void execute(List<String> sqlQueries) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            for (String sqlQuery : sqlQueries) {
                stmt.executeUpdate(sqlQuery);
            }
        } catch (Exception e) {
            log.info("Ошибка при выполнении запроса - " + e.getMessage(), e);
        } finally {
            closeStatement(stmt);
        }
    }

    private void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void resultSetClose(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Map<String, String>> executeQuery(String sqlQuery) {
        Statement stmt = null;
        ResultSet rs = null;
        List<Map<String, String>> results = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                Map<String, String> resultsTmp = new HashMap<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColumns = rsmd.getColumnCount();
                for (int i = 1; i < numColumns + 1; i++) {
                    try {
                        resultsTmp.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnLabel(i)));
                    } catch (SQLException e) {
                        resultsTmp.put(rsmd.getColumnName(i), null);
                    }
                }
                results.add(resultsTmp);
            }
        } catch (Exception e) {
            throw new AssertionError(String.format("Ошибка при выполнении запроса [%s] - " + e.getMessage(), sqlQuery), e);
        } finally {
            resultSetClose(rs);
            closeStatement(stmt);
        }
        return results;
    }
}
