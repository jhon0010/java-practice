package domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {

    private long id;
    private String name;
    private int tier;
}
