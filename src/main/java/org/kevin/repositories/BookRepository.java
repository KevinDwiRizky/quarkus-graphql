package org.kevin.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kevin.entities.Book;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
}
