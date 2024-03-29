package features_versions.eight_8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Allow us to manage the possible null values in the better way.
 */
public class OptionalCreation {

    private static final Logger LOGGER = Logger.getLogger(OptionalCreation.class.getName());

    public static void main(String[] args) {


        String str = "Some String";
        // Returns an Optional which contains a non-null value.
        Optional<String> optionalStr = Optional.of(str);
        LOGGER.info("The Optional.of(str).get return " + optionalStr.get());

        try {
            final Optional<Object> optNull = Optional.of(null);
            LOGGER.info("The Optional.of(null) get returns " + optNull.get());
        } catch (NullPointerException npe) {
            LOGGER.warning("The Optional.of(null).get returns NullPointerException , \n" +
                    "because the constructor have requireNonNull clause");
        }

        try {
            Optional<String> optionalEmpty = Optional.empty();
            LOGGER.info("The Optional.empty() get returns " + optionalEmpty.get()); // java.util.NoSuchElementException
        } catch (NoSuchElementException nsee) {
            LOGGER.warning("The Optional.empty().get returns NoSuchElementException , \n" +
                    " because the constructor have the value null (Wrapper)");
        }

        try {
            // Will return an Optional with a specific value or an empty Optional if the parameter is null.
            Optional<String> optionalOfNullable = Optional.ofNullable(getString());
            LOGGER.info("The Optional.ofNullable(getString()).get returns " + optionalOfNullable.get());
        } catch (NoSuchElementException nsee) {
            LOGGER.warning("The Optional.ofNullable(getString()).get returns NoSuchElementException , \n" +
                    " that means that getString() return null value");
        }


    }

    private static String getString(){
        return System.currentTimeMillis() % 2 == 0
                ? "Have a value" : null;
    }

}
