import java.sql.SQLException;

import controllers.MovieController;

public class MovieDatabaseApplication {

    public static void main(String[] args) throws SQLException {
        MovieController mc = new MovieController();
        mc.systemRunner();
    }

}
