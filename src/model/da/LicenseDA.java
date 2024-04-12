package model.da;

import com.sun.java.browser.plugin2.liveconnect.v1.Result;
import model.entity.License;

import java.sql.*;

public class LicenseDA {
    private Connection connection;
    private PreparedStatement preparedStatement;

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javase",
                "java123"
        );
    }

    private void disconnect() throws  SQLException {
        preparedStatement.close();
        connection.close();
    }

    public void save(License license) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO LICENSE(ID,FILE_NAME,LICENSE_TYPE,FILE_SIZE) VALUES (LICENSE_SEQ.NEXTVAL, ?,?,?,?)"
        );
        preparedStatement.setString(1, license.getFileName());
        preparedStatement.setString(2, license.getLicenseType());
        preparedStatement.setInt(3, license.getFileSize());
        preparedStatement.setString(4, license.getDescription());
        preparedStatement.execute();
        disconnect();
    }

    public void edit(License license) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO LICENSE(ID,FILE_NAME,LICENSE_TYPE,FILE_SIZE) VALUES (LICENSE_SEQ.NEXTVAL, ?,?,?,?)"
        );
        preparedStatement.setString(1, license.getFileName());
        preparedStatement.setString(2, license.getLicenseType());
        preparedStatement.setInt(3, license.getFileSize());
        preparedStatement.setString(4, license.getDescription());
        preparedStatement.execute();
        disconnect();
    }

    public void remove(License license) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO LICENSE(ID,FILE_NAME,LICENSE_TYPE,FILE_SIZE) VALUES (LICENSE_SEQ.NEXTVAL, ?,?,?,?)"
        );
        preparedStatement.setString(1, license.getFileName());
        preparedStatement.setString(2, license.getLicenseType());
        preparedStatement.setInt(3, license.getFileSize());
        preparedStatement.setString(4, license.getDescription());
        preparedStatement.execute();
        disconnect();
    }
    public boolean findById(int id) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM LICENSE WHERE ID=?"
        );

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean Result = resultSet.next();
        disconnect();
        return Result;
    }
}
