package test;

import model.da.BookDA;
import model.entity.Book;

public class BookTest {
    public static void main(String[] args) throws Exception {
//        Book book =new Book();
//        book.setName("sag koshi");
//        book.setAuthor("pishi");
//        book.setIsbn("879874564646");
//        BookDA bookDA = new BookDA();
//        //test passed
//        bookDA.save(book);

//        Book book =new Book();
//        book.setName("ash");
//        book.setId(1);
//        book.setAuthor("khale");
//        book.setIsbn("212121");
//        BookDA bookDA = new BookDA();
//        //test passed
//        bookDA.edit(book);

//        BookDA bookDA = new BookDA();
//        //test passed
//        bookDA.remove(1);
//

//        BookDA bookDA = new BookDA();
//        //test passed
//        System.out.println(bookDA.findAll());

//        BookDA bookDA = new BookDA();
//        //test passed
//        System.out.println(bookDA.findByName("sag koshi"));

//        BookDA bookDA = new BookDA();
//        //test passed
//        System.out.println(bookDA.findById(6));

        BookDA bookDA = new BookDA();

        System.out.println(bookDA.findByAuthor("pishi"));
    }
}
