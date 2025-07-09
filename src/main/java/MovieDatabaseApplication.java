import java.sql.SQLException;

import controllers.MovieController;
import services.MovieActorService;

public class MovieDatabaseApplication {

    public static void main(String[] args) throws SQLException {
        MovieController mc = new MovieController();
        mc.systemRunner();
//        MovieActorService mcs = new MovieActorService();
//        mcs.getAllActors();
    }

}
