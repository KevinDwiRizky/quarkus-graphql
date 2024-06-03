package org.kevin.services;

import org.kevin.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book addBook(String title, String author);
    Book getBook(Long id);
    Book updateBook(Long id, String title, String author);
    boolean deleteBook(Long id);
}
