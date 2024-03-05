package features_versions.eight_8.streams.operators.terminal;

import domain.Customer;
import domain.Order;
import domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * The .collect method in Java Streams is a terminal operation that transforms the elements of a stream into a different
 * form, usually a collection like a List, Set, or Map, or even other types like a String.
 * This method is highly versatile and is used to gather elements from a stream into a result container.
 * The .collect method takes a Collector as an argument, which defines how the stream will be collected.
 */
public class CollectorsExamples {

    private static final Logger LOGGER = Logger.getLogger(CollectorsExamples.class.getName());

    public static void main(String[] args) {

        List<Order> orders = Order.getExampleOrderList();

        // Print the products from the orders
        getProductsFromOrders(orders).forEach(x -> LOGGER.info(x.toString()));

        // Print the distinct customers from the orders
        getDistinctCustomers(orders).forEach(x -> LOGGER.info(x.toString()));

        // Print the map of products from the orders
        getMapOfProducts(orders).forEach((k,v) -> LOGGER.info("Key: " + k + " Value: " + v));

    }

    /**
     * toList(): Collects the elements of the stream into a List
     */
    public static List<Product> getProductsFromOrders(List<Order> orders) {

        LOGGER.info("Getting products from orders");

        return orders.stream()
                .map(Order::getProducts)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * toSet(): Collects the elements of the stream into a Set
     * If you want to keep the same customers (by content) you should override the equals and hashcode methods.
     */
    public static Set<Customer> getDistinctCustomers(List<Order> orders) {

        LOGGER.info("Getting distinct customers from orders");

        return orders.stream()
                .map(Order :: getCustomer)
                .collect(Collectors.toSet());
    }

    /**
     * toMap(): Collects the elements of the stream into a Map.
     *
     * You will get an error if the key is duplicated.
     * Use (existingValue, newValue) -> existingValue to keep the first encountered value in case of a duplicate key
     */
    public static Map<String,String> getMapOfProducts(List<Order> orders) {

        LOGGER.info("Getting map of products from orders");

        /*
        In this example, if Collectors.toMap() encounters duplicate keys, the merge function
        (existingValue, newValue) -> existingValue ensures that the first encountered value is kept
        and the subsequent duplicate key's value is ignored.
         */
        return orders.stream()
                .map(Order::getProducts)
                .flatMap(List::stream)
                .collect(Collectors.toMap(Product::getId, Product::getName,(existingValue, newValue) -> existingValue));

    }

}
