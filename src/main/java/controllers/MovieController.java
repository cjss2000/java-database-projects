package controllers;

import services.MovieDatabaseService;
import services.MovieView;

import java.sql.SQLException;

//public class MovieController() {
//    private MovieView mv;
//}

public class MovieController{

MovieView mv = new MovieView();
MovieDatabaseService mds = new MovieDatabaseService();

    public MovieController() throws SQLException {
    }


    public void systemRunner() throws SQLException {
    boolean isRunning = true;
    while (isRunning){
        mv.displayMenuBoard();
       int choice = mv.numberInput("Please select your choice");

       switch (choice) {
           case 1:
               mds.getAllMovies();
               break;

           case 2:
             //  mds.addMovie();


       }
    }
}

}
