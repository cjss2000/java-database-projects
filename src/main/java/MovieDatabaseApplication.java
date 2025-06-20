import java.sql.SQLException;

import controllers.MovieController;
import services.MovieDatabaseService;
import services.database_config.DatabaseConnection;

public class MovieDatabaseApplication {

    public static void main(String[] args) throws SQLException {
        MovieController mc = new MovieController();
        mc.systemRunner();
      //  DatabaseConnection dc = new DatabaseConnection();
        try {
            MovieDatabaseService movieDatabaseService = new MovieDatabaseService();
        //   movieDatabaseService.addMovie(11111,"Testing Movie", 1999);
            System.out.println(movieDatabaseService.getAllMovies());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
