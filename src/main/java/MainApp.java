
import entity.Book;
import jakarta.persistence.EntityManager;
import service.BookService;
import service.CustomerService;
import service.OrderService;
import util.JPAUtil;

public class MainApp {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        BookService bookService = new BookService(em);
        CustomerService customerService = new CustomerService(em);
        OrderService orderService = new OrderService(em);

        bookService.createSampleBooks();
        customerService.createSampleCustomers();
        orderService.createSampleOrders();

        em.getTransaction().commit();

        System.out.println("=== Danh sách sách ===");
        for (Book b : bookService.getAllBooks()) {
            System.out.println(b.getIsbn() + " - " + b.getTitle() + " - $" + b.getPrice());
        }

        System.out.println("\n=== Danh sách đơn hàng ===");
        orderService.getAllOrders().forEach(o ->
                System.out.println("Order #" + o.getId() + ": Customer=" + o.getCustomerId()
                        + ", Book=" + o.getBookIsbn() + ", Date=" + o.getDate()));

        em.close();
        JPAUtil.close();
    }
}