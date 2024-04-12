package model.da;

import model.entity.Person;

import java.sql.*;

public class PersonDA {
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
                "INSERT INTO PERSON(ID,NAME,FAMILY,NATIONAL_ID) VALUES (PERSON_SEQ.NEXTVAL, ?,?,?)"
        );
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setString(3, person.getNationalId());
        preparedStatement.execute();
        disconnect();
    }

    public boolean findByNationalId(String nationalId) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PERSON WHERE NATIONAL_ID=?"
        );
        preparedStatement.setString(1, nationalId);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }
}
