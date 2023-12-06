package features_versions.eight_8.functional;

import domain.Gender;
import domain.User;

import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This is a functional interface and can therefore be used as
 * the assignment target for a lambda expression or method reference.
 *
 * Represents a predicate (boolean-valued function) of one argument.
 */
public class PredicateUsers {

    private static final Logger LOGGER = Logger.getLogger(PredicateUsers.class.getName());

    public static void main(String[] args) {

        List<User> users = User.defaultList();

        Predicate<User> femaleUserPredicate = user -> user.getGender().equals(Gender.FEMALE);

        List<User> femaleUsers = users.stream()
                .filter(femaleUserPredicate)
                .collect(Collectors.toList());
        femaleUsers.stream()
                .map(User::toString)
                .forEach(LOGGER::info);
    }
}
