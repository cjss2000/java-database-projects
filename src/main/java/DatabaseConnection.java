//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DatabaseConnection {
//
//    private static String URL = "jdbc:mysql://localhost:3306/demo_db";
//    private static String USERNAME = "root";
//    private static String PASSWORD = "root";
//
//    public static void main(String[] args) throws SQLException {
//
//        Connection customConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        String COMMAND = "select * from customers;";
//
//        Statement statement = customConnection.createStatement();
//        ResultSet resultSet = statement.executeQuery(COMMAND);
//        while (resultSet.next()) {
//            int ID = resultSet.getInt("customer_id");
//            String name = resultSet.getString("first_name");
//            System.out.println("ID: " + ID + ", name: " + name + ", created at: " + resultSet.getDate("created_at"));
//        }
//        System.out.println();
//    }
//
//}
