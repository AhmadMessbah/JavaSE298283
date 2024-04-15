package model.da;

import model.entity.Book;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDA {
    Connection connection;
    PreparedStatement statement;
    public void connect() throws Exception{
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "java",
                "java123"
        );
    }
    public void disconnect()throws Exception {
        statement.close();
        connection.close();

    }
    public void save(Book book)throws Exception{
        connect();
        statement = connection.prepareStatement(
                "insert into BOOK(id, name,author ,isbn ) values (BOOK_SEQ.nextval,?,?,?)"
        );
        statement.setString(1, book.getName());
        statement.setString(2,book.getAuthor());
        statement.setString(3,book.getIsbn());
        statement.execute();
        disconnect();

    }

    public void edit(Book book)throws Exception{
    connect();
        statement = connection.prepareStatement(
                "update BOOK set NAME=? , AUTHOR=? , ISBN=? where ID=?"
        );
        statement.setString(1, book.getName());
        statement.setString(2,book.getAuthor());
        statement.setString(3,book.getIsbn());
        statement.setInt(4,book.getId());
        statement.execute();
        disconnect();
    }
    public void remove(int id)throws Exception{
        connect();
        statement = connection.prepareStatement(
                "delete from BOOK where ID=?"
        );
        statement.setInt(1,id);
        statement.execute();
        disconnect();

    }
public int findByName(String name)throws Exception{
    List<Book> bookList = new ArrayList<>();
    connect();
    statement = connection.prepareStatement(
            "select * from BOOK where NAME=?"
    );
    statement.setString(1,name);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getString("isbn"));
        bookList.add(book);
    }
    disconnect();
    return bookList.size();
}
    public List<Book> findAll()throws Exception{
        List<Book> bookList = new ArrayList<>();
        connect();
        statement = connection.prepareStatement(
                "select * from BOOK"
        );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setIsbn(resultSet.getString("isbn"));
            bookList.add(book);

        }
        disconnect();
        return bookList;
    }
    public Book findById(int id)throws Exception{
        connect();
        statement = connection.prepareStatement(
                "select * from BOOK where ID=?"
        );
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setIsbn(resultSet.getString("isbn"));

        disconnect();
        return book;
    }
    public List<Book> findByAuthor(String author)throws Exception{
        List<Book> bookList = new ArrayList<>();
        connect();
        statement = connection.prepareStatement(
                "select * from BOOK where AUTHOR=?"
        );
        statement.setString(1,author);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setIsbn(resultSet.getString("isbn"));
            bookList.add(book);
        }
        disconnect();
        return bookList;
    }

}

