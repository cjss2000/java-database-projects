package services;

import services.database_config.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class MovieCastService {
    private DatabaseConnection connection;
    private Statement statement;

    public MovieCastService() throws SQLException {
        this.connection = new DatabaseConnection();
        this.statement = connection.getStatement();
    }
}