package features_versions.eight_8.functional;

import java.util.function.BiFunction;
import java.util.logging.Logger;

/**
 * Take two arguments and return one.
 */
public class BiFunctionPractice {

    private static final Logger LOGGER = Logger.getLogger(BiFunctionPractice.class.getName());

    public static void main(String[] args) {

        var number = 4;

        LOGGER.info("Result of operation Imperative = " + sumPlusOneAndMultiply(number, number));
        LOGGER.info("Result of operation Functional = " + sumPlusOneAndMultiply.apply(number, number));
    }

    static BiFunction<Integer, Integer, Integer> sumPlusOneAndMultiply = (number,multiplyBy) -> (number + 1) * multiplyBy;

    /**
     * Imperative way
     */
    static int sumPlusOneAndMultiply(int number, int multiplyBy){
        return (number + 1) * multiplyBy;
    }

}
