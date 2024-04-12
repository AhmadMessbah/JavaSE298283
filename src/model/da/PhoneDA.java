package model.da;
import model.entity.Phone;

import java.sql.*;
import java.util.*;

public class PhoneDA {
    private Connection connection;
    private PreparedStatement preparedStatement;

    private void connect() throws Exception {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "java";
        String userMain = "javase";
        String password = "java123";
        connection = DriverManager.getConnection(
                url,
                user,
                password
        );
    }

    private void disconnect() throws Exception {
        preparedStatement.close();
        connection.close();
    }

    public void save(Phone phone) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PHONE(" +
                        "ID,FIRST_NAME,LAST_NAME,BRAND, PRICE, COLOR, SERIAL_NUMBER) " +
                        "VALUES (PHONE_SEQ.NEXTVAL, ?,?,?,?,?,?)"
        );

        preparedStatement.setString(1, phone.getFirstName());
        preparedStatement.setString(2, phone.getLastName());
        preparedStatement.setString(3, phone.getBrand());
        preparedStatement.setDouble(4, phone.getPrice());
        preparedStatement.setString(6, phone.getColor());
        preparedStatement.setString(5, phone.getSerial());
        preparedStatement.execute();
        disconnect();
    }

    public void edit(int id, String brand) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "UPDATE PHONE SET BRAND=? WHERE ID=?"
        );
        preparedStatement.setString(1, brand);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
        disconnect();
    }

    public void remove(int id) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PHONE WHERE ID=?"
        );

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        disconnect();
    }

    public List<Phone> showAll () throws  Exception {
        connect();
        List<Phone> phoneList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM PHONE");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Phone phone = new Phone(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"),
                    resultSet.getString("LAST_NAME"), resultSet.getString("BRAND"),
                    resultSet.getString("COLOR"), resultSet.getString("SERIAL_NUMBER"),
                    resultSet.getDouble("PRICE"));
            phoneList.add(phone);
        }

        disconnect();

        return phoneList;
    }
}
