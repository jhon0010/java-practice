package domain;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {

    private String id;
    private String name;
    private Double price;
    private String category;
    private Date createdAt;
    private List<Comment> comments;

}
