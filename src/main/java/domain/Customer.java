package domain;

import java.util.Objects;

public class Customer {

    public Customer() {
    }

    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    private long id;
    private String name;
    private int tier;

    public static Customer getRandomCustomer() {
        return new Customer(1, "John Doe", 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTier());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

}
