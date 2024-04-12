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

    public void save(Lesson lesson)throws SQLException{
        connect();
       preparedStatement = connection.prepareStatement(
               "INSERT INTO Lesson(ID,NAME,CLASSNO,INPERSONCODE,ONLINECODE,STARTDATE) VALUES (LESSON_SEQ.NEXTVAL,?,?,?,?,?)"

       );
       preparedStatement.setString(1,lesson.getName());
       preparedStatement.setString(2,lesson.getClassNo());
       preparedStatement.setString(3,lesson.getInPersonCode());
       preparedStatement.setString(4,lesson.getOnlineCode());
       preparedStatement.setTimestamp(5, Timestamp.valueOf(lesson.getStartDateTime()));

    }
    public void edit(Lesson lesson)throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE LESSON SET ... WHERE ID=?");
    }

    public boolean findById(String inPersonCode)throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM LESSON WHERE INPERSONCODE=?"
        );
        preparedStatement.setString(1, inPersonCode);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }
    public boolean findAll(String inPersonCode)throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM LESSON WHERE INPERSONCODE=?"
        );
        preparedStatement.setString(1, inPersonCode);
        ResultSet resultset = preparedStatement.executeQuery();
        boolean result = resultset.next();
        disconnect();
        return result;
    }
}
