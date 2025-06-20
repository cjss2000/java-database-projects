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
               handleAddMovie();
               break;
           case 3:
               handleDeleteMovie();
               break;
           case 4:
               handleEditMovieName();
               break;
           case 5:
               handleMovieDetails();
               break;
           case 6:
               isRunning = false;
               mv.displayMessage("ending application");
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

public void handleDeleteMovie() throws SQLException {
        int movieToDeleteId = mv.numberInput("Please provide your ID number for movie to remove:");
        mds.deleteMovieByID(movieToDeleteId);
}

//public void handleConductSQLQuery() throws SQLException {
//        String query = mv.userInput("Conduct SQL Query here: ");
//   //     mds.conductQuery(query);
//
//}

public void handleEditMovieName() throws SQLException {
    String updatedMovieName = mv.userInput("Please enter the updated moviename");
    int movieId = mv.numberInput("Please enter your existing movie id");

    mds.editMovieNamefromId(movieId, updatedMovieName);

}

public void handleMovieDetails() throws SQLException {
        int movieId = mv.numberInput("Please enter your movie ID for more information");
        mds.getMovieDetailsByID(movieId);

}

}
