package domain;


import java.util.Date;
import java.util.List;

public class Product {

    private String id;
    private String name;
    private Double price;
    private String category;
    private Date createdAt;
    private List<Comment> comments;

    public Product(String number, String s, double v, String s1, Date date, List<Comment> exampleCommentList) {
        this.id = number;
        this.name = s;
        this.price = v;
        this.category = s1;
        this.createdAt = date;
        this.comments = exampleCommentList;
    }

    public static List<Product> getExampleProductList(){
        return List.of(
                new Product("1", "Product 1", 100.0, "Category 1", new Date(), Comment.getExampleCommentList()),
                new Product("2", "Product 2", 200.0, "Category 2", new Date(), Comment.getExampleCommentList()),
                new Product("3", "Product 3", 300.0, "Category 3", new Date(), Comment.getExampleCommentList()),
                new Product("4", "Product 4", 400.0, "Category 4", new Date(), Comment.getExampleCommentList()),
                new Product("5", "Product 5", 500.0, "Category 5", new Date(), Comment.getExampleCommentList())
        );
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", createdAt=" + createdAt +
                ", comments=" + comments +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
