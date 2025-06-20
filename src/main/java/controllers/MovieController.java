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
               handleAllMoviesDisplay();
               break;

           case 2:
             //  mds.addMovie();
               handleAddMovie();
               break;
           case 3:
               break;
           case 4:
               break;
           case 5:
               mds.conductQuery(mv.userInput("Please conduct your query here: "));
               break;
           case 6:
               isRunning = false;
               break;


       }
    }
}

public void handleAllMoviesDisplay() throws SQLException {
        mds.getAllMovies();


}

public void handleAddMovie() throws SQLException {
int inputMovie_ID = mv.numberInput("Please enter your movie id");
String inputMovieName = mv.userInput("What is the title?");
int inputMovie_year = mv.numberInput("What year was this movie created?");
mds.addMovie(inputMovie_ID,inputMovieName,inputMovie_year);
}

public void handleConductSQLQuery() throws SQLException {
        String query = mv.userInput("Conduct SQL Query here: ");
        mds.conductQuery(query);

}


}
