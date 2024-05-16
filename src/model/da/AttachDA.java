package model.da;

import model.entity.Attach;

import java.sql.*;

public class AttachDA {
    private Connection connection;
    private PreparedStatement preparedStatement;

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javase",
                "java123"
        )
    }

    private void disconnect() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    public void save(Attach attach) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO ATTACH(ID , PERSON_ID , LICENSE_ID) VALUES (ATTACH_SEQ.NEXTVAL, ?,?,?)create table ATTACH(ID int, PERSON_ID int, LICENSE_ID int)/"
        );
        preparedStatement.setInt(1, attach.getId());
        preparedStatement.setInt(2, attach.getPersonId());
        preparedStatement.setInt(3, attach.getLicenseId());
        preparedStatement.execute();
        disconnect();
    }

    public void edit(Attach attach) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO ATTACH(ID , PERSON_ID , LICENSE_ID) VALUES (ATTACH_SEQ.NEXTVAL, ?,?,?)"
        );
        preparedStatement.setInt(1, attach.getId());
        preparedStatement.setInt(2, attach.getPersonId());
        preparedStatement.setInt(3, attach.getLicenseId());
        preparedStatement.execute();
        disconnect();
    }

    public void remove(Attach attach) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO ATTACH(ID , PERSON_ID , LICENSE_ID) VALUES (ATTACH_SEQ.NEXTVAL, ?,?,?)"
        );
        preparedStatement.setInt(1, attach.getId());
        preparedStatement.setInt(2, attach.getPersonId());
        preparedStatement.setInt(3, attach.getLicenseId());
        preparedStatement.execute();
        disconnect();
    }

    public boolean findById(int id) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM ATTACH WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }

    public boolean findByPersonId(int personId) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM ATTACH WHERE PERSON_ID=?"
        );
        preparedStatement.setInt(1, personId);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }

    public boolean findByLicenseId(int licenseId) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM ATTACH WHERE LICENSE_ID=?"
        );
        preparedStatement.setInt(1, licenseId);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }



}


