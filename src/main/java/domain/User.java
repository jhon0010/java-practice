package domain;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class User {

    private static final int THRESHOLD_ADULT = 18;

    private int age;
    private String name;
    private String lastName;
    private Optional<String> email;
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int age, String name, String lastName, Gender gender) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }

    public boolean isAdult(User u) {
        return u.age >= THRESHOLD_ADULT;
    }

    public static boolean isValidUser(User user) {
        return !user.name.equals(user.lastName);
    }

    public static List<User> defaultList() {

        return asList(
                new User(27, "Jhon", "Doe", Gender.MALE),
                new User(18, "Just", "Adult", Gender.MALE),
                new User(27, "Maria", "Doe", Gender.FEMALE),
                new User(22, "Peter", "Peter", Gender.MALE),
                new User(40, "Fernanda", "Other", Gender.FEMALE),
                new User(27, "Estefania", "Gonzales", Gender.FEMALE),
                new User(12, "Boy1", "Doe", Gender.MALE),
                new User(3, "Baby", "Doe", Gender.FEMALE),
                new User(17, "Young", "Doe", Gender.FEMALE)
        );
    }

    public static User getAnExampleUser() {
        return new User(27, "Jhon","",  Gender.MALE);
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

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
