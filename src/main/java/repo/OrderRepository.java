package repo;


import entity.Order;
import jakarta.persistence.EntityManager;
import java.util.List;

public class OrderRepository {
    private EntityManager em;

    public OrderRepository(EntityManager em) {
        this.em = em;
    }

    public void save(entity.Order order) {
        em.persist(order);
    }

    public List<Order> findAll() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }
}