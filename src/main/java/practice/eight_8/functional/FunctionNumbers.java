package practice.eight_8.functional;

import org.slf4j.Logger;

import java.util.function.Function;

import static org.slf4j.LoggerFactory.getLogger;

public class FunctionNumbers {

    private static final Logger LOGGER = getLogger(FunctionNumbers.class);

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
    }


//    static Function<Integer, Integer> increase1AndMultiplyByItself = functionIncrease.andThen(multiplyFunction); //ERROR
    static Function<Integer, Integer> functionIncrease = number -> number++;
    static Function<Integer, Integer> multiplyFunction = number -> number * number;

    static int increase(int number){
        return number++;
    }

}
