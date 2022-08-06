package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3307/CRUDv3";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "1234";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problem whit connect from MySQL");
        }
        return connection;
    }

}
