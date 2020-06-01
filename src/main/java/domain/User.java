package domain;

import java.util.List;

import static java.util.Arrays.asList;

public class User {

    private static int THRESHOLD_ADULT = 18;

    private int age;
    private String name;
    private String lastName;

    public User() {
    }

    public User(int age, String name, String lastName) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public User(String name) {
       this.name = name;
       this.age = 99;
       this.lastName = "";
    }

    public boolean isAdult(User user){
        return user.age >= THRESHOLD_ADULT;
    }

    public static boolean isValidUser(User user){
        return !user.name.equals(user.lastName);
    }

    public static List<User> defaultList(){

        return asList(
            new User(5,"Jhon", "Doe"),
            new User(18, "Just", "Adult"),
            new User(22,"Peter","Peter")
        );
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
