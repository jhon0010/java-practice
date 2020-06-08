package domain;

import java.util.List;

import static java.util.Arrays.asList;

public class User {

    private static int THRESHOLD_ADULT = 18;

    private int age;
    private String name;
    private String lastName;
    private Gender gender;

    public User() {
    }

    public User(int age, String name, String lastName, Gender gender) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
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
            new User(27,"Jhon", "Doe", Gender.MALE),
            new User(18, "Just", "Adult", Gender.MALE),
            new User(27,"Maria","Doe", Gender.FEMALE),
            new User(22,"Peter","Peter", Gender.MALE),
            new User(40,"Fernanda","Other", Gender.FEMALE),
            new User(27,"Estefania","Gonzales", Gender.FEMALE)
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
