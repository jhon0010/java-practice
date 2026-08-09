package features_versions.eight_8.functional;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * A first order function is the one that is referenced by the class, receive a function and return a function.
 */
public class FunctionPractice {

    private static final Logger LOGGER = Logger.getLogger(FunctionPractice.class.getName());
    
    static Function<Integer, Integer> functionIncrease = number -> number+1;
    static Function<Integer, Integer> multiplyFunction = number -> number * number;

    static int increase(int number){
        return number+1;
    }
    public static void main(String[] args) {

        var number = 2;
        int increaseMethod = increase(number);
        LOGGER.info("Number " + number + " increase by method " + increase(number));

        Integer functionResult = functionIncrease.apply(number);
        LOGGER.info("Number " + number + " increase by function " + functionResult);

        /**
         * The combination couldn't be static referenced.
         */
        Function<Integer, Integer> increase1AndMultiplyByItself = functionIncrease.andThen(multiplyFunction);
        LOGGER.info("Number " + number + " increase by function " + increase1AndMultiplyByItself.apply(number));
        /**
         * The difference with andThen is the order of function execution.
         */
        Function<Integer, Integer> increase1AndMultiplyByItselfCompose = functionIncrease.compose(multiplyFunction);
    }

}
