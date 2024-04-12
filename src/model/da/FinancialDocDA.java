package model.da;

import model.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FinancialDocDA {
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
    public void save(Person person) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO FINANCIAL_DOC(ID) VALUES (FINANCIAL_DOC.NEXT, ?,?,?)"
        );
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setString(3, person.getNationalId());
        preparedStatement.execute();
        disconnect();
    }
    public void edit(Person person) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO FINANCIAL_DOC(ID) VALUES (FINANCIAL_DOC.NEXT, ?,?,?)"
        );
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setString(3, person.getNationalId());
        preparedStatement.execute();
        disconnect();
    }
    public void findAll(Person person) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO FINANCIAL_DOC(ID) VALUES (FINANCIAL_DOC.NEXT, ?,?,?)"
        );
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setString(3, person.getNationalId());
        preparedStatement.execute();
        disconnect();
    }
}