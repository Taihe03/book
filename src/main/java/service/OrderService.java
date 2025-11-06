package service;

import entity.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import repo.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class OrderService {
    private final repo.OrderRepository repo;

    public OrderService(EntityManager em) {
        this.repo = new OrderRepository(em);
    }

    public void createSampleOrders() {
        repo.save(new Order(LocalDate.now(), "C001", "ISBN001"));
        repo.save(new Order(LocalDate.now(), "C001", "ISBN002"));
        repo.save(new Order(LocalDate.now(), "C002", "ISBN003"));
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}