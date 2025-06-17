package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Movie;
import services.database_config.DatabaseConnection;

public class MovieDatabaseService {

    private DatabaseConnection connection;
    private Statement statement;

    public MovieDatabaseService() throws SQLException {
        this.connection = new DatabaseConnection();
        this.statement = connection.getStatement();
    }

    public void addMovie(int movie_id, String movie_name, int movie_year) throws SQLException {
        String createMovieCommand =
       //     "INSERT INTO movie(movie_id, movie_name, movie_year) VALUES (" + movie_id + ", " + movie_name + ", " + + movie_year + ");";
                "INSERT INTO movie(movie_id, movie_name, movie_year) VALUES (" + movie_id + ", '" + movie_name + "', " + movie_year + ");";
        int rowsAffected = statement.executeUpdate(createMovieCommand);
        System.out.println("The following rows were inserted: " + rowsAffected);
    }

    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> list = new ArrayList<>();
        String getAllMoviesCommand = "select * from movie;";
        ResultSet resultSet = statement.executeQuery(getAllMoviesCommand);
        while (resultSet.next()) {
            int movie_id = resultSet.getInt("movie_id");
            String movie_name = resultSet.getString("movie_name");
            int movie_year = resultSet.getInt("movie_year");
            Movie movie = new Movie(movie_id, movie_name, movie_year);
            list.add(movie);
        }
        return list;
    }

    public void conductQuery(String query) throws SQLException {
       ResultSet rs = statement.executeQuery(query);

    }

//    public Movie getMovieByTitle(String title){
//        for (Movie movie : list){
//
//        }
//    }
}
