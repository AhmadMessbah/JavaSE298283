package model.da;

import model.entity.House;
import model.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HouseDA {
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

    public void save(House house) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO HOUSE(ID,ADDRESS,MEASURE,ROOM,REGION) VALUES (HOUSE_SEQ.NEXTVAL, ?,?,?)"
        );
        preparedStatement.setString(1, house.getAddress());
        preparedStatement.setInt(2, house.getMeasure());
        preparedStatement.setInt(3, house.getRoom());
        preparedStatement.setString(3, house.getRegion());
        preparedStatement.execute();
        disconnect();
    }
    public void edit(House house) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "UPDATE HOUSE SET ... WHERE ID=?"
        );
        preparedStatement.setInt(1, house.getId());

        preparedStatement.execute();
        disconnect();
    }

}
