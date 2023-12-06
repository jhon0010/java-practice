package features_versions.eight_8.functional;

import org.slf4j.Logger;

import java.util.function.Function;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * A first order function is the one that is referenced by the class, receive a function and return a function.
 */
public class FunctionPractice {

    private static final Logger LOGGER = getLogger(FunctionPractice.class);

    public static void main(String[] args) {

        var number = 1;
        int increaseMethod = increase(number);
        LOGGER.info("Number " + number + " increase by method " + increaseMethod);

        Integer functionResult = functionIncrease.apply(number);
        LOGGER.info("Number " + number + " increase by function " + functionResult);

        /**
         * The combination couldn't be static referenced.
         */
        Function<Integer, Integer> increase1AndMultiplyByItself = functionIncrease.andThen(multiplyFunction);

        /**
         * The difference with andThen is the order of function execution.
         */
        Function<Integer, Integer> increase1AndMultiplyByItselfCompose = functionIncrease.compose(multiplyFunction);
    }


//    static Function<Integer, Integer> increase1AndMultiplyByItself = functionIncrease.andThen(multiplyFunction); //ERROR
    static Function<Integer, Integer> functionIncrease = number -> number++;
    static Function<Integer, Integer> multiplyFunction = number -> number * number;

    static int increase(int number){
        return number++;
    }

}
