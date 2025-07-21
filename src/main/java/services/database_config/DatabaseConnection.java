package services.database_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: This class needs to be created ONCE per project,
// therefore we need to implement the Singleton logic directly HERE
public class DatabaseConnection {

    private static String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    // TODO 1: create a private static variable of type DatabaseConnection

    private Connection customConnection;
    private Statement statement;

    // TODO 2: make this constructor private
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

    // TODO 3: create a getInstance() method here that would check if your static variable from point 2 above is null
    // if it is - it would create an object for it, otherwise return the existing object

}