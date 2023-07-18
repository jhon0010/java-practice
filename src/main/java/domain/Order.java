package domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {

    private long id;
    private Status status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public enum Status {
        ORDERED,
        ON_ROAD,
        DELIVERED,
        COMPLETE
    }
}
