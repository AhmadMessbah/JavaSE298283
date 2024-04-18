package controller;



import model.bl.BookBL;
import model.entity.Book;

import java.util.regex.Pattern;

public class BookController {
    public static String save(String name, String author, String isbn) {
        try {
            if (
                    Pattern.matches("^[a-zA-Z\\s]{2,40}$", name)
                            && Pattern.matches("^[a-zA-Z\\s]{2,40}$", author)
                            && Pattern.matches("^\\d{20}$", isbn)
            ) {
                Book book = Book.builder().name(name).author(author).isbn(isbn).build();
                BookBL.save(book);
                return "Person Saved.";
            } else {
                return "Error : Invalid Data";
            }

        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }

    }
}