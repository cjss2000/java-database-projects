package services;

import models.Actor;
import services.database_config.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Movie;
import services.database_config.DatabaseConnection;

public class MovieActorService {
    private DatabaseConnection connection;
    private Statement statement;

    public MovieActorService() throws SQLException {
        this.connection = new DatabaseConnection();
        this.statement = connection.getStatement();
    }

    public List<Actor>getAllActors() throws SQLException {
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

    public void addActor(String actorName, String actorGender, int actorBirthYear) throws SQLException {
        String addActorCommand = "INSERT INTO actor(actor_name, actor_gender, actor_birth_year) VALUES ('" + actorName + "', '" + actorGender + "', " + actorBirthYear + ");";
        int rowsAffected = statement.executeUpdate(addActorCommand);
        System.out.println("The following rows has been inserted: " + rowsAffected);
    }
    public void deleteActorbyId(int actorId) throws SQLException {
        String deleteRowCommand = "DELETE FROM actor WHERE actor_id = " + actorId + ";";
        int executeDeleteRowCommand = statement.executeUpdate(deleteRowCommand);
        System.out.println("Deleted" + executeDeleteRowCommand + " row" + actorId);
    }
}
