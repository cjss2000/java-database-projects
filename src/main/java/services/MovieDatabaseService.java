package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Movie;
import services.database_config.DatabaseConnection;
import services.database_config.SingletonExample;

public class MovieDatabaseService {

    private DatabaseConnection connection;
    private SingletonExample singletonExample;
    private Statement statement;

    public MovieDatabaseService() throws SQLException {
        this.connection = new DatabaseConnection();
        this.singletonExample = SingletonExample.getInstance();
        this.statement = connection.getStatement();
    }

    public void addMovie(String movie_name, int movie_year) throws SQLException {
        String createMovieCommand = "INSERT INTO movie(movie_name, movie_year) VALUES ('" + movie_name + "', " + movie_year + ");";
        int rowsAffected = statement.executeUpdate(createMovieCommand);
        System.out.println("The following rows were inserted: " + rowsAffected);
    }

    public void deleteMovieByID(int movie_id) throws SQLException {
        String DeleteRowCommand = "DELETE FROM movie WHERE movie_id = " + movie_id + ";";
        int executeDeleteRowCommand = statement.executeUpdate(DeleteRowCommand);
        System.out.println("Deleted" + executeDeleteRowCommand + " row " + movie_id);
    }

    public void editMovieNamefromId(int movie_id, String updatedMovieName) throws SQLException {
        String updateMovie =
            "UPDATE movie SET movie_name = '" + updatedMovieName + "' WHERE movie_id = " + movie_id + ";";
        int rowsAffected = statement.executeUpdate(updateMovie);
        System.out.println("Movie has been succcessfully updated");
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


    public void getMovieDetailsByID(int movie_id) throws SQLException {
        String movie_id_select = "SELECT * FROM movie WHERE movie_id ="  + movie_id + ";";
        ResultSet resultSet = statement.executeQuery(movie_id_select);
        while (resultSet.next()){
            int movieId = resultSet.getInt("movie_id");
            String movie_name = resultSet.getString("movie_name");
            int movie_year = resultSet.getInt("movie_year");
            Movie movie = new Movie(movieId, movie_name, movie_year);
            System.out.println(movie.toString());
        }

    }

}
