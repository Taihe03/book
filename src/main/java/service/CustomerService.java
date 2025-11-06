package service;



import entity.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import repo.CustomerRepository;

import java.util.List;

@Stateless
public class CustomerService {
    private final repo.CustomerRepository repo;

    public CustomerService(EntityManager em) {
        this.repo = new CustomerRepository(em);
    }

    public void createSampleCustomers() {
        repo.save(new Customer("C001", "Nguyen Van A", "a@gmail.com"));
        repo.save(new Customer("C002", "Tran Thi B", "b@gmail.com"));
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }
}