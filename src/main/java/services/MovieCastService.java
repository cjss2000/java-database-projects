package services;

import models.MovieCast;
import services.database_config.DatabaseConnection;

import javax.management.relation.Role;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieCastService {
    private DatabaseConnection connection;
    private Statement statement;

    public MovieCastService() throws SQLException {
        this.connection = new DatabaseConnection();
        this.statement = connection.getStatement();
    }

    public List<MovieCast>getAllMovieCastRoles() throws SQLException {
        List<MovieCast> list = new ArrayList<>();
        String retrieveAllMovieCastRoles = "select * from movie_cast;";
        ResultSet resultSet = statement.executeQuery(retrieveAllMovieCastRoles);
        while (resultSet.next()){
            String movieRole = resultSet.getString("role");
            MovieCast movieCast = new MovieCast(movieRole);
            list.add(movieCast);
        }
        return list;
    }


}