package repo;
import entity.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BookRepository {
    private EntityManager em;

    public BookRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Book book) {
        em.persist(book);
    }

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}