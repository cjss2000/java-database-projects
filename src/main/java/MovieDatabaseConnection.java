import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDatabaseConnection {

    private static String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";


    public static void main(String[] args) throws  SQLException {

        Connection customConnection = DriverManager.getConnection(URL,USERNAME,PASSWORD);


        String createMovieCommand = "INSERT INTO movie(movie_name, movie_year) VALUES (\"Home Alone\", \"1990\");";
        String COMMAND = "select * from movie;";

        try (Statement statement = customConnection.createStatement()) {
            //ResultSet resultSet = statement.executeQuery(COMMAND);
            //why did this have to be moved in order for it to create/read the result set?
            int rowsAffected = statement.executeUpdate(createMovieCommand);
            System.out.println("The following rows were inserted: " + rowsAffected);

            ResultSet resultSet = statement.executeQuery(COMMAND);
            while (resultSet.next()) {
                String movie_id = resultSet.getString("movie_id");
                System.out.println("Movie ID" + movie_id);
                String movie_name = resultSet.getString("movie_name");
                System.out.println("Movie name" + movie_name);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }
}
