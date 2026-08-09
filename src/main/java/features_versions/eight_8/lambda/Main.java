package features_versions.eight_8.lambda;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    record Product(String name, String category, double price) {}
    record Order(int id, String customerName, List<Product> products) {}
    record Employee(String name, String department, String city, double salary) {}

    public static void main(String[] args) {
        List<Product> tech = List.of(
                new Product("Laptop", "Tech", 1200.0),
                new Product("Mouse", "Tech", 25.0),
                new Product("Keyboard", "Tech", 75.0)
        );

        List<Product> home = List.of(
                new Product("Lamp", "Home", 40.0),
                new Product("Chair", "Home", 150.0)
        );

        List<Order> orders = List.of(
                new Order(101, "Alice", tech),
                new Order(102, "Bob", home),
                new Order(103, "Charlie", List.of(new Product("Laptop", "Tech", 1200.0))),
                new Order(104, "Alice", List.of(new Product("Headphones", "Tech", 100.0)))
        );

        List<Employee> employees = List.of(
                new Employee("Alice", "Tech", "New York", 120000),
                new Employee("Bob", "Sales", "New York", 80000),
                new Employee("Charlie", "Tech", "London", 150000),
                new Employee("Dave", "Sales", "London", 90000),
                new Employee("Eve", "HR", "New York", 60000),
                new Employee("Frank", "Tech", "London", 130000)
        );

        // get all tech products sorted by price desc
        orders.stream()
                .flatMap(o -> o.products.stream())
                .filter(p -> p.category.equals("Tech"))
                .distinct()
                .sorted(Comparator.comparingDouble(Product::price))
                .forEach(System.out::println);


        // get total buy price for each customer
        orders.stream()
                .collect(Collectors.groupingBy(
                        Order::customerName,
                        Collectors.summingDouble(o -> o.products.stream().mapToDouble(Product::price).sum())
                ))
        .forEach((customerName, total) -> System.out.println(customerName + ": " + total));

        // get total buy price for each category
        orders.stream()
                .flatMap(o -> o.products.stream())
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.summingDouble(Product::price)
                ))
                .forEach((category, total) -> System.out.println(category + ": " + total));

        // get order with most products
        orders.stream()
                .max(Comparator.comparingInt(o -> o.products.size()))
                .ifPresent(System.out::println);

        Map<String, Map<String,List<Employee>>> employeesByCityAndDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::city,
                        Collectors.groupingBy(
                                Employee::department
                        )
                ));
        System.out.println(employeesByCityAndDepartment.get("New York").get("Tech"));


        Map<String, Optional<Employee>> maxSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.maxBy(Comparator.comparingDouble(e -> e.salary))
                ));
        maxSalaryByDepartment.forEach((department, employee) -> System.out.println(department + ": " + employee.get().name));


        Map<Boolean, List<String>> employesOver100 = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.salary > 100000,
                        Collectors.mapping(Employee::name, Collectors.toList())
                        )
                );
        System.out.println(employesOver100.get(true));
        System.out.println(employesOver100.get(false));


        DoubleSummaryStatistics employeesStats = employees.stream()
                .filter(e -> e.department.equals("Tech"))
                .collect(Collectors.summarizingDouble(e -> e.salary));

        System.out.println(employeesStats);

    }
}
