package services;

import models.Actor;
import services.database_config.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Actor;
import services.database_config.DatabaseConnection;
import services.database_config.SingletonExample;

// TODO: rename this class for consistency to ActorService
public class MovieActorService {

    private DatabaseConnection connection;
    private Statement statement;


    public MovieActorService() throws SQLException {
        // TODO: change this object creation here and in all other places to a static method call getInstance()
        this.connection = new DatabaseConnection();
        this.statement = connection.getStatement();
    }

    public List<Actor> getAllObjects() throws SQLException {
        List<Actor> list = new ArrayList<>();
        String retrieveAllActorsCommand = "select * from actor;";
        ResultSet resultSet = statement.executeQuery(retrieveAllActorsCommand);
        while (resultSet.next()) {
            int actorId = resultSet.getInt("actor_id");
            String actorName = resultSet.getString("actor_name");
            String actorGender = resultSet.getString("actor_gender");
            int actorDOB = resultSet.getInt("actor_birth_year");
            Actor actor = new Actor(actorId, actorName, actorGender, actorDOB);
            list.add(actor);
        }
        return list;
    }

    public void addObject(String actorName, String actorGender, int actorBirthYear) throws SQLException {
        String addActorCommand =
            "INSERT INTO actor(actor_name, actor_gender, actor_birth_year) VALUES ('" + actorName + "', '" + actorGender
                + "', " + actorBirthYear + ");";
        int rowsAffected = statement.executeUpdate(addActorCommand);
        System.out.println("The following rows has been inserted: " + rowsAffected);
    }

    public void deleteObjectByID(int actorId) throws SQLException {
        String deleteRowCommand = "DELETE FROM actor WHERE actor_id = " + actorId + ";";
        int executeDeleteRowCommand = statement.executeUpdate(deleteRowCommand);
        System.out.println("Deleted" + executeDeleteRowCommand + " row" + actorId);
    }

    public Actor getObjectById(int actorId) throws SQLException {
        Actor actor = null;
        int actor_id = actorId;
        String actor_id_select = "SELECT * FROM movie WHERE actor_id ="  + actor_id + ";";
        ResultSet resultSet = statement.executeQuery(actor_id_select);
        while (resultSet.next()){
             actor_id = resultSet.getInt("actor_id");
             String actor_name = resultSet.getString("actor_name");
             int actorBirthYear = resultSet.getInt("actor_birth_year");
             actor = new Actor(actor_id, actor_name, actorBirthYear);
        }
        return actor;
    }
}
