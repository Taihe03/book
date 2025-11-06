package service;

import entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import repo.BookRepository;

import java.util.List;

@Stateless
public class BookService {
    private final repo.BookRepository repo;

    public BookService(EntityManager em) {
        this.repo = new BookRepository(em);
    }

    public void createSampleBooks() {
        repo.save(new Book("ISBN001", "Clean Code", 25.5));
        repo.save(new Book("ISBN002", "Effective Java", 30.0));
        repo.save(new Book("ISBN003", "Domain-Driven Design", 40.0));
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }
}