package model.bl;

import model.da.BookDA;
import model.entity.Book;

public class BookBL {
    public static void save(Book book) throws Exception{
        BookDA bookDA =new BookDA();
        if (bookDA.findByISBN(book.getIsbn())){
            throw new Exception("Duplicate Book !!!");

        }else {
            bookDA.save(book);
        }
    }
}
