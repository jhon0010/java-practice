package practice.eight_8.streams;

import domain.Gender;
import domain.User;
import org.slf4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class UserStream {

    private static final Logger LOGGER = getLogger(UserStream.class);

    public static void main(String[] args) {

        final List<User> users = User.defaultList();
        getFemales(users);
        sortByAge(users);
        reverseSort(users);
        multipleSorting(users);
        allMatch(users);
        anyMatch(users);
        noneMatch(users);
        oldestUserMax(users);
        groupByGender(users);
        getFirstNameOldestFemale(users);
    }

    private static void getFirstNameOldestFemale(List<User> users) {
        users.stream()
                .filter(user -> user.getGender() == Gender.FEMALE)
                .max(Comparator.comparing(User::getAge))
                .map(User::getName)
                .ifPresent(LOGGER::info);
    }

    private static void groupByGender(List<User> users) {

        final Map<Gender, List<User>> userByGender = users.stream()
                .collect(Collectors.groupingBy(User::getGender));

        userByGender.forEach((gender, usersResult) -> {
            LOGGER.info(gender.name());
            usersResult.stream().map(User::toString).forEach(LOGGER::info);
        });
    }

    private static void oldestUserMax(List<User> users) {
        users.stream().max(Comparator.comparing(User::getAge))
         .ifPresent(user -> LOGGER.info(user.toString()));
    }

    private static void noneMatch(List<User> users) {
        final boolean anyMatch = users.stream().noneMatch(user -> user.getName().contains("J"));
        LOGGER.info("None Match for J returns " + anyMatch);
    }

    private static void anyMatch(List<User> users) {
        final boolean anyMatch = users.stream().anyMatch(user -> user.getName().contains("J"));
        LOGGER.info("Any Match for J returns " + anyMatch);
    }

    /**
     * If one element of the stream doesn't fill the predicate so the allMatch method stop
     * and return false.
     */
    private static void allMatch(List<User> users) {
        final boolean areAllAdults = users.stream().allMatch(user -> user.getAge() > 18);
        LOGGER.info("Are all adults " + areAllAdults);
    }

    /**
     * The gender comparator just compare the position of the value in the enum.
     */
    private static void multipleSorting(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getGender))
                .map(User::toString)
                .forEach(LOGGER::info);
    }

    private static void reverseSort(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .map(User::toString)
                .forEach(LOGGER::info);
    }

    private static void sortByAge(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .map(User::toString)
                .forEach(LOGGER::info);
    }

    private static void getFemales(List<User> users) {
        final List<User> femalesInList = users.stream()
                .filter(u -> u.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());
        femalesInList.stream().map(User::toString).forEach(LOGGER::info);
    }
}
