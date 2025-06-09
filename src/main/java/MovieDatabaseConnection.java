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

        String COMMAND = "select * from movie;";

        try (Statement statement = customConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(COMMAND);

            while (resultSet.next()) {
                String movie_id = resultSet.getString("movie_id");
                System.out.println("Movie ID" + movie_id);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }
}
