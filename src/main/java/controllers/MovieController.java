package controllers;

import java.util.List;
import models.Movie;
import services.MovieDatabaseService;
import views.MovieView;

import java.sql.SQLException;

public class MovieController {

    private MovieView mv;
    private MovieDatabaseService mds;

    public MovieController() throws SQLException {
        this.mv = new MovieView();
        this.mds = new MovieDatabaseService();
    }

    public void systemRunner() throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
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
                    printMovieInfo(handleMovieIDCheck());
                    break;
                case 7:
                    isRunning = false;
                    mv.displayMessage("ending application");
                    break;

                // TODO: add a default case for the switch statement (show an error)
            }
        }
    }

    public void handleAllMoviesDisplay() throws SQLException {
        List<Movie> movieList = mds.getAllMovies();
        // TODO: use a for - loop to iterate over the movies in the list above
        for (int i = 0; i < movieList.size(); i++) {
            mv.displayMessage("Here is your list:" + movieList.get(i).toString());
        }
        // call a toString method for each of them
        // pass the String to the view for it to be printed
    }

    public void handleAddMovie() throws SQLException {
        String inputMovieName = mv.userInput("What is the title?");
        int inputMovie_year = mv.numberInput("What year was this movie created?");
        mds.addMovie(inputMovieName, inputMovie_year);
        mv.displayMessage("your movie has been added");
        handleAllMoviesDisplay();
        // TODO: call the view here to say that movie was added
    }

    public void handleDeleteMovie() throws SQLException {
        int movieToDeleteId = mv.numberInput("Please provide your ID number for movie to remove:");
        mds.deleteMovieByID(movieToDeleteId);
        mv.displayMessage("Movie has been successfully deleted");
        handleAllMoviesDisplay();
        // TODO: call the view here to say that movie was deleted
    }

    public void handleEditMovieName() throws SQLException {
        String updatedMovieName = mv.userInput("Please enter the updated moviename");
        int movieId = mv.numberInput("Please enter your existing movie id");
        mds.editMovieNamefromId(movieId, updatedMovieName);
        mv.displayMessage("Movie:" + movieId + "has been updated");

        //user getter to get name
        // TODO: call the view here to say that movie was updated
    }

    public void handleMovieDetails() throws SQLException {
        int movieId = mv.numberInput("Please enter your movie ID for more information");
        mv.displayMessage("Here is your current movie information");
        mds.getMovieDetailsByID(movieId);

        // TODO: call the view here to display movie details
    }

    public void printMovieInfo(Movie movie){
        mv.displayMessage(movie.toString());
    }

    // TODO: add a method that checks if the movie with such ID exists in the database
    public Movie handleMovieIDCheck() throws SQLException {
        List<Movie> movieList = mds.getAllMovies();
        int movieId = mv.numberInput("Please enter your ID for checking service");
        for (Movie movie : movieList){
            if (movieId == movie.getMovieId()) {
                mv.displayMessage("Your movie has been found by the id!");
                return movie;

            }

        }


        return null;
    }
}
    // TODO: BONUS: add a movie genre functionality

