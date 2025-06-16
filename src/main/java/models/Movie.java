package models;

public class Movie {

    private int movieId;
    private String movieName;
    private int movieYear;

    public Movie(int movieId, String movieName, int movieYear) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieYear = movieYear;
    }

    public int getMovieYear(){
        return movieYear;
    }
    public void setMovieYear(){
        this.movieYear = movieYear;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int id) {
        this.movieId = id;
    }

    @Override
    public String toString() {
        return "Movie id: " + movieId + ", movie name: " + movieName + ", movie year" + movieYear;
    }
}
