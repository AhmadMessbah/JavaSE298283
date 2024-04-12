package model.da;

import model.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDA {
    public void save(Person person) throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javase",
                "java123"
        );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO PERSON(ID,NAME,FAMILY,NATIONAL_ID) VALUES (PERSON_SEQ.NEXTVAL , ?,?,?)"
        );
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setString(3, person.getNationalId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public boolean findByNationalId(String nationalId) throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "java",
                "java123"
        );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM PERSON WHERE NATIONAL_ID=?"
        );
        preparedStatement.setString(1, nationalId);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        preparedStatement.close();
        connection.close();
        return result;
    }
}
