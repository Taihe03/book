package entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String customerId;
    private String bookIsbn;

    public Order() {}

    public Order(LocalDate date, String customerId, String bookIsbn) {
        this.date = date;
        this.customerId = customerId;
        this.bookIsbn = bookIsbn;
    }

    public Long getId() { return id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getBookIsbn() { return bookIsbn; }
    public void setBookIsbn(String bookIsbn) { this.bookIsbn = bookIsbn; }
}