import java.sql.SQLException;
import services.MovieDatabaseService;

public class MovieDatabaseApplication {

    public static void main(String[] args) {
        try {
            MovieDatabaseService movieDatabaseOperations = new MovieDatabaseService();
            movieDatabaseOperations.addMovie("Test", "1990");
            movieDatabaseOperations.getAllMovies();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
