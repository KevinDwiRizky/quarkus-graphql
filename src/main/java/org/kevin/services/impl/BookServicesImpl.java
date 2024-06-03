package org.kevin.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.kevin.entities.Book;
import org.kevin.repositories.BookRepository;
import org.kevin.services.BookService;

import java.util.List;

@ApplicationScoped
public class BookServicesImpl implements BookService {
    @Inject
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.listAll();
    }

    @Override
    @Transactional
    public Book addBook(String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.persist(book);
        return book;
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, String title, String author) {
        Book book = bookRepository.findById(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            bookRepository.persist(book);
        }
        return book;
    }

    @Override
    @Transactional
    public boolean deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }
}
