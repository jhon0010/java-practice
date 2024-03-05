package domain;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Order {

    private long id;
    private Status status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(long id, Status status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public enum Status {
        ORDERED,
        ON_ROAD,
        DELIVERED,
        COMPLETE
    }

    public static List<Order> getExampleOrderList() {

        return Arrays.asList(
                new Order(1, Status.ORDERED, LocalDate.now(), LocalDate.now().plusDays(2), Product.getExampleProductList(), Customer.getRandomCustomer()),
                new Order(2, Status.ORDERED, LocalDate.now(), LocalDate.now().plusDays(2), Product.getExampleProductList(), Customer.getRandomCustomer()),
                new Order(3, Status.ORDERED, LocalDate.now(), LocalDate.now().plusDays(2), Product.getExampleProductList(), Customer.getRandomCustomer()),
                new Order(4, Status.ORDERED, LocalDate.now(), LocalDate.now().plusDays(2), Product.getExampleProductList(), Customer.getRandomCustomer()),
                new Order(5, Status.ORDERED, LocalDate.now(), LocalDate.now().plusDays(2), Product.getExampleProductList(), Customer.getRandomCustomer())
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
