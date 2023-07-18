package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private static final int THRESHOLD_ADULT = 18;

    private int age;
    private String name;
    private String lastName;
    private Optional<String> email;
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public User(String name) {
        this.name = name;
    }

    public User(int age, String name, String lastName, Gender gender) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
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

        return User.builder()
                .name("Jhon")
                .lastName("Lotero")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.of(1990, 11, 16))
                .email(Optional.of("jhon@gmail.com"))
                .gender(Gender.MALE)
                .build();
    }

    public boolean isAdult(User user) {
        return user.age >= THRESHOLD_ADULT;
    }

}
