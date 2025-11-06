package repo;

import entity.Customer;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> findAll() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
}