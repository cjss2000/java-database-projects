package services.database_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private Connection customConnection;
    private Statement statement;

    public DatabaseConnection() throws SQLException {
        this.customConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getCustomConnection() {
        return customConnection;
    }

    public Statement getStatement() throws SQLException {
        this.statement = customConnection.createStatement();
        return statement;
    }
}
