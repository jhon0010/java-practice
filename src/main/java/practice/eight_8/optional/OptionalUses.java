package practice.eight_8.optional;

import domain.Gender;
import domain.User;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.slf4j.LoggerFactory.getLogger;

public class OptionalUses {

    private static final Logger LOGGER = getLogger(OptionalUses.class);

    public static void main(String[] args) {

        List<String> listOpt = getTodayWinnerNames().orElseGet(ArrayList::new);
        LOGGER.info("The optional list returns " + listOpt.toString());

        String possibleWorld = null;

        possibleNullableString(possibleWorld);
        getWordWithOrElse(possibleWorld);
        executingOrMethod(possibleWorld);
        orElseThrow(possibleWorld);
        ifIsPresent(possibleWorld);
        useOptionalWithObjects();

    }

    private static void useOptionalWithObjects() {
        User user = new User(18, "John", "Doe", "john.DOE@GmAil.com", Gender.MALE, "+0578978978987", LocalDate.now());

        String userEmailLowerCase = user.getEmail()
                .map(String::toLowerCase)
                .orElse("no-mail");
        LOGGER.info("The mail for the user ".concat(user.getName()).concat(" is ").concat(userEmailLowerCase));
    }

    private static void ifIsPresent(String possibleWorld) {
        Optional.ofNullable(possibleWorld)
                .ifPresent(word -> {
                    LOGGER.info("The word " + word + " of nullable is present");
                });

        Optional.ofNullable(possibleWorld)
                .ifPresentOrElse(word -> {
                    LOGGER.info("The word " + word + " of nullable is present");
                }, () -> {
                    LOGGER.error("The expected world is not present, sorry man :(");
                });

        Optional.ofNullable(possibleWorld)
                .ifPresentOrElse(LOGGER::info, () -> LOGGER.error("The expected world is not present, sorry man :("));
    }

    private static void orElseThrow(String possibleWorld) {
        Optional.ofNullable(possibleWorld)
                .orElseThrow(() -> new RuntimeException("Value no present, so throw exception!"));
    }

    private static void executingOrMethod(String possibleWorld) {
        Optional<String> executingOrMethod = Optional.ofNullable(possibleWorld)
                .or(() -> {
                    LOGGER.warn("Executing or method");
                    //You can return also an Optional if you are not sure about if the value is present or not.
                    return Optional.of("or world!");
                });
        LOGGER.info("Result or method = ".concat(executingOrMethod.get()));
    }

    private static void getWordWithOrElse(String possibleWorld) {
        String wordWithOrElse = Optional.ofNullable(possibleWorld)
                .orElseGet(() -> {
                    // do another things
                    LOGGER.warn("The expect word is null, trying to get the word from Redis");
                    return "Word getting of some external tool like Redis";
                });
        LOGGER.info("The or else word is ".concat(wordWithOrElse));
    }

    private static void possibleNullableString(String possibleWorld) {
        Optional<String> optPossibleWorld = Optional.ofNullable(possibleWorld);
        String upperCase = optPossibleWorld
                .map(String::toUpperCase) // only is executed if the value is present
                .map(word -> word.concat("World!"))
                .orElse("No present");
        LOGGER.info(upperCase);
    }


    private static Optional<List<String>> getTodayWinnerNames() {

        List<String> names = asList("John", "Doe", "Bean", "Peter");
        return System.currentTimeMillis() % 2 == 0
                ? Optional.of(names) : Optional.empty();
    }

}
