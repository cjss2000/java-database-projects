import java.sql.SQLException;
import services.MovieDatabaseOperations;

public class MovieDatabaseApplication {

    public static void main(String[] args) {
        try {
            MovieDatabaseOperations movieDatabaseOperations = new MovieDatabaseOperations();
            movieDatabaseOperations.addMovie("Test", "1990");
            movieDatabaseOperations.getAllMovies();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
