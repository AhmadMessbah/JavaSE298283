package model.da;
import model.entity.Lesson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class LessonDA {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private void connect() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mft",
                "root",
                "Sh@ron19"
        );
    }
    private void disconnect() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    public void save()throws SQLException{
        connect();
       preparedStatement = connection.prepareStatement(
               "INSERT INTO LESSON(ID,NAME,CLASSNO,INPERSONCODE,ONLINECODE,STARTDATE) VALUES (PERSON_SEQ.NEXTVAL,?,?,?,?,?)"

       );

    }
}
