package features_versions.eight_8.functional;

import org.slf4j.Logger;

import java.util.function.Predicate;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Takes one argument and return a boolean value.
 *
 * You can combine them with others predicates.
 */
public class PredicatePractice {

    private static final Logger LOGGER = getLogger(PredicatePractice.class);

    public static void main(String[] args) {

        String validEmail = "jhon.doe@gmail.com";
        String invalidEmail = "jhongmail.com";

        LOGGER.info("The email " + validEmail + " is valid ? " + isValidEmailPredicate.test(validEmail));
        LOGGER.info("The email " + invalidEmail + " is valid ? " + isValidEmailPredicate.test(invalidEmail));

        combinePredicates(validEmail);


    }

    private static void combinePredicates(String validEmail) {
        // we can combine the predicates
        if (isValidEmailPredicate.and(isGmailEmail).test(validEmail)) {
            LOGGER.info("We have special offer to gmail users");
        } else {
            LOGGER.info("We trait you as a normal user");
        }
    }

    static Predicate<String> isValidEmailPredicate = email -> email.contains("@") && email.length() > 5;

    static Predicate<String> isGmailEmail = email -> email.contains("gmail");

    static boolean isValidEmailByMethod(String email) {
        return email.contains("@") && email.length() > 5;
    }

}
