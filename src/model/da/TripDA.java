package model.da;

import model.entity.Trip;
import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class TripDA {

    private Connection connection;
    private PreparedStatement preparedStatement;

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javase",
                "java123"
        );
    }

    private void disconnect() throws SQLException {
        preparedStatement.close();
        connection.close();
    }
    public void save(Trip trip) throws Exception {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO TRIP(ID,DESTINATION,DESCRIPTION,TAGS) VALUES (TRIP_SEQ.NEXTVAL , ?,?,?)"
        );
        preparedStatement.setString(1, trip.getDestination());
        preparedStatement.setString(2, trip.getDescription());
        preparedStatement.setString(3, trip.getTags());
        preparedStatement.execute();
        disconnect();
    }

    public void edit(Trip trip) throws Exception {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE TRIP SET DESTINATION = ?,DESCRIPTION = ?,TAGS = ? WHERE ID = ?"
        );
        preparedStatement.setString(1, trip.getDestination());
        preparedStatement.setString(2, trip.getDescription());
        preparedStatement.setString(3, trip.getTags());
        preparedStatement.setInt(4, trip.getId());
        preparedStatement.execute();
        disconnect();
    }

    public void remove(int id) throws Exception {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM TRIP WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        disconnect();
    }
    public List<Trip>  findAll() throws Exception {
        List<Trip> tripList = new ArrayList<>();
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM TRIP"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Trip trip = new Trip();
            trip.setId(resultSet.getInt("id"));
            trip.setDestination(resultSet.getString("destination"));
            trip.setDescription(resultSet.getString("description"));
            trip.setTags(resultSet.getString("tags"));
            tripList.add(trip);
        }
        disconnect();
        return tripList;
    }

    public List<Trip>  findById(int id) throws Exception {
        List<Trip> tripList = new ArrayList<>();
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM TRIP WHERE ID=?"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.setInt(1, id);
        while (resultSet.next()) {
            Trip trip = new Trip();
            trip.setId(resultSet.getInt("id"));
            trip.setDestination(resultSet.getString("destination"));
            trip.setDescription(resultSet.getString("description"));
            trip.setTags(resultSet.getString("tags"));
            tripList.add(trip);
        }
        disconnect();
        return tripList;
    }

    public List<Trip>  findByDestination(String destination) throws Exception {
        List<Trip> tripList = new ArrayList<>();
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM TRIP WHERE DESTINATION=?"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.setString(1, destination);
        while (resultSet.next()) {
            Trip trip = new Trip();
            trip.setId(resultSet.getInt("id"));
            trip.setDestination(resultSet.getString("destination"));
            trip.setDescription(resultSet.getString("description"));
            trip.setTags(resultSet.getString("tags"));
            tripList.add(trip);
        }
        disconnect();
        return tripList;
    }


}




