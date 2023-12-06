package features_versions.eight_8.streams;

import domain.Gender;
import domain.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * the Stream API is used to process collections of objects.
 * A stream is a sequence of objects that supports various methods
 * which can be pipelined to produce the desired result.
 */
public class UserStream {

    private static final Logger LOGGER = Logger.getLogger(UserStream.class.getName());

    public static void main(String[] args) {


        final List<User> users = User.defaultList();

        //users.stream().map(User::getAge).sorted().forEach(System.out::println);

        Map<Character, Integer> repetitions = new HashMap();

        String word =  "leetcode";

        Optional<Character> first = repetitions.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey);



        int[] nums = {1, 1, 2, 24, 5, 2, 3, 6, 3};
        int[] nums2 = {1, 1, 2, 24, 5, 2, 3, 6, 3};
        Stream.of(nums, nums2)
                .flatMapToInt(IntStream::of)
                .forEach(System.out::println);

//        Arrays.stream(nums).distinct().forEach(System.out::println);


//        Integer[] numsWrapped = {1, 1, 2, 24, 5, 2, 3, 6, 3};
//        List<Integer> q = Arrays.asList(numsWrapped);
//
//        List<Integer> list = List.of(1, 1, 2, 24, 5, 2, 3, 6, 3);
//        list.stream().flatMap(i -> Stream.of(i + 10, i + 20)).forEach(System.out::println);



/*        getFemales(users);
        sortByAge(users);
        reverseSort(users);
        multipleSorting(users);
        allMatch(users);
        anyMatch(users);
        noneMatch(users);
        oldestUserMax(users);
        groupByGender(users);
        getFirstNameOldestFemale(users);
        findAny(users);
        allMatch(users);
        findFirst(users);*/


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
        final boolean noneMatchHotmail = users.stream().noneMatch(user -> user.getEmail().orElse("").contains("hotmail"));
        LOGGER.info("There are no people using hotmail? = " + noneMatchHotmail);
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


    private static void findAny(List<User> users) {

        Optional<User> user = users.stream().findAny();
        LOGGER.info("Stream findAny returns a user" + user.orElse(null));
    }


    private static void findFirst(List<User> users) {

        Optional<User> user = users.stream().findFirst();
        LOGGER.info("Stream findAny returns a user" + user.orElse(null));
    }

}
