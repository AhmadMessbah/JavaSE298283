package model.da;

import model.entity.Person;
import model.entity.SimCard;

import java.sql.*;

public class SimCardDA {
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


    public void save(SimCard simcard) throws Exception {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO SIM_CARD(ID,SIM_NUMBER,PUK_NUMBER,OPERATOR) VALUES (SIM_CARD_SEQ.NEXTVAL , ?,?,?)"
        );
        preparedStatement.setString(1, simcard.getSimNumber());
        preparedStatement.setString(2, simcard.getPukNumber());
        preparedStatement.setString(3, simcard.getOperator());
        preparedStatement.execute();
        disconnect();
    }

    public void edit(SimCard simcard) throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javase",
                "java123"
        );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO SIM_CARD(ID,SIM_NUMBER,PUK_NUMBER,OPERATOR) VALUES (SIM_CARD_SEQ.NEXTVAL , ?,?,?)"
        );
        preparedStatement.setString(1, simcard.getSimNumber());
        preparedStatement.setString(2, simcard.getPukNumber());
        preparedStatement.setString(3, simcard.getOperator());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}