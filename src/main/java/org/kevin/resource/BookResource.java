package org.kevin.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.graphql.*;
import org.kevin.entities.Book;
import org.kevin.repositories.BookRepository;
import org.kevin.services.BookService;

import java.util.List;


@GraphQLApi
public class BookResource {

    @Inject
    private BookService bookService;

    @Query("allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Mutation
    @Transactional
    public Book addBook(String title, String author) {
        return bookService.addBook(title, author);
    }

    @Query
    public Book getBook(Long id) {
        return bookService.getBook(id);
    }

    @Mutation
    @Transactional
    public Book updateBook(Long id, String title, String author) {
        return bookService.updateBook(id, title, author);
    }

    @Mutation
    @Transactional
    public boolean deleteBook(Long id) {
        return bookService.deleteBook(id);
    }
}
