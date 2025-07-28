package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Movie;
import services.database_config.DatabaseConnection;

// TODO: Cleanup the classes so that we have just the methods that are a part of the interface + private if any
//completed!
public class MovieService implements CrudOperations<Movie> {

    private DatabaseConnection connection;
    private Statement statement;

    public MovieService() throws SQLException {
//        this.connection = new DatabaseConnection();
//        this.statement = connection.getStatement();
        DatabaseConnection.getInstance();
    }

    //    public void addObject(String movie_name, int movie_year) throws SQLException {
//        String createMovieCommand = "INSERT INTO movie(movie_name, movie_year) VALUES ('" + movie_name + "', " + movie_year + ");";
//        int rowsAffected = statement.executeUpdate(createMovieCommand);
//        System.out.println("The following rows were inserted: " + rowsAffected);
//    }

    @Override
    public void addObject(Movie movie) throws SQLException {
        String createMovieCommand =
            "INSERT INTO movie(movie_name, movie_year) VALUES ('" + movie.getMovieName() + "', " + movie.getMovieYear()
                + ");";
        int rowsAffected = statement.executeUpdate(createMovieCommand);
        System.out.println("The following rows were inserted: " + rowsAffected);
    }

    //notating this before I forget, movie_name and movie_year were parameters inside addMovie method, but no longer, so now I have to use my get methods to add them to the create movie command string

    @Override
    public Movie deleteObjectById(int movie_id) throws SQLException {
        String DeleteRowCommand = "DELETE FROM movie WHERE movie_id = " + movie_id + ";";
        int executeDeleteRowCommand = statement.executeUpdate(DeleteRowCommand);
        System.out.println("Deleted" + executeDeleteRowCommand + " row " + movie_id);
    }
    //I undestand I need to return a Movie object, but couldn't this method also be of type void?

    @Override
    public Movie getObjectById(int movie_id) throws SQLException {
        Movie movie = null;
        String movie_id_select = "SELECT * FROM movie WHERE movie_id =" + movie_id + ";";
        ResultSet resultSet = statement.executeQuery(movie_id_select);
        while (resultSet.next()) {
            int movieId = resultSet.getInt("movie_id");
            String movie_name = resultSet.getString("movie_name");
            int movie_year = resultSet.getInt("movie_year");
            movie = new Movie(movieId, movie_name, movie_year);

        }
        return movie;
    }

    public void editMovieNamefromId(int movie_id, String updatedMovieName) throws SQLException {
        String updateMovie =
            "UPDATE movie SET movie_name = '" + updatedMovieName + "' WHERE movie_id = " + movie_id + ";";
        int rowsAffected = statement.executeUpdate(updateMovie);
        System.out.println("Movie has been succcessfully updated");
    }

    public List<Movie> getAllObjects() throws SQLException {
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


    // TODO: return Movie object instead of void and this needs to be fixed in all other services to so that
    //completed!
    // getById methods return an object instead of printing the details
//    public void getMovieDetailsByID(int movie_id) throws SQLException {
//        String movie_id_select = "SELECT * FROM movie WHERE movie_id ="  + movie_id + ";";
//        ResultSet resultSet = statement.executeQuery(movie_id_select);
//        while (resultSet.next()){
//            int movieId = resultSet.getInt("movie_id");
//            String movie_name = resultSet.getString("movie_name");
//            int movie_year = resultSet.getInt("movie_year");
//            Movie movie = new Movie(movieId, movie_name, movie_year);
//            System.out.println(movie.toString());
//        }
//
//    }
    public Movie getObjById(int movie_id) throws SQLException {
        Movie movie = null;
        String movie_id_select = "SELECT * FROM movie WHERE movie_id =" + movie_id + ";";
        ResultSet resultSet = statement.executeQuery(movie_id_select);
        while (resultSet.next()) {
            int movieId = resultSet.getInt("movie_id");
            String movie_name = resultSet.getString("movie_name");
            int movie_year = resultSet.getInt("movie_year");
            movie = new Movie(movieId, movie_name, movie_year);

        }
        return movie;
    }


}
