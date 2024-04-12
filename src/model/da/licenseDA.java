package model.da;
import model.entity.License;
import model.entity.Person;
import java.sql.*;

public class licenseDA {
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

    public void save(License license) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO LICENSE(ID,LICENSE_TYPE,FILE_NAME,FILE_SIZE, DESCRIPTION) VALUES (LICENSE_SEQ.NEXTVAL, ?,?,?,?)"
        );
        preparedStatement.setString(1, license.getLicenseType());
        preparedStatement.setString(2, license.getFileName());
        preparedStatement.setInt(3, license.getFileSize());
        preparedStatement.setString(4, license.getDescription());
        preparedStatement.execute();
        disconnect();
    }

    public void edit(License license) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO LICENSE(ID,LICENSE_TYPE,FILE_NAME,FILE_SIZE, DESCRIPTION) VALUES (LICENSE_SEQ.NEXTVAL, ?,?,?,?)"
        );
        preparedStatement.setString(1, license.getLicenseType());
        preparedStatement.setString(2, license.getFileName());
        preparedStatement.setInt(3, license.getFileSize());
        preparedStatement.setString(4, license.getDescription());
        preparedStatement.execute();
        disconnect();
    }

    public void remove(License license) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO LICENSE(ID,LICENSE_TYPE,FILE_NAME,FILE_SIZE, DESCRIPTION) VALUES (LICENSE_SEQ.NEXTVAL, ?,?,?,?)"
        );
        preparedStatement.setString(1, license.getLicenseType());
        preparedStatement.setString(2, license.getFileName());
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
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }

    public boolean findByFileName(String fileName) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM LICENSE WHERE FILE_NAME=?"
        );
        preparedStatement.setString(1, fileName);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }
}
