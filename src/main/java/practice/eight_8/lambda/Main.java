package practice.eight_8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * A lambda expression is mainly build by :
 *
 *      Parameters | Operator | expression to evaluate
 *
 * For example :
 *
 *      (String name1, String name2) -> name1.compareTo(name2)
 *
 * Imperative = How to do something , step by step.
 * Declarative = What do you want to do.
 *
 * The lambda code is more concise and declarative than the imperative approach.
 *
 * All anonymous class can be replaced by lambda expression.
 *
 */
public class Main {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        List<String> names = asList("John", "Doe", "Bean", "Peter");
        imperativeApproach(names);
        declarativeApproach(names);
        declarativeApproachWIthMethodReference(names);
        overrateAntonymousClass();
        inferringArgumentsType();

    }

    private static void inferringArgumentsType() {
        OperationFunctionalInterface op = (x, y) -> x+ y;
    }

    private static void overrateAntonymousClass() {
        // anonymous class implementation imperative way
        OperationFunctionalInterface op = new OperationFunctionalInterface() {
            @Override
            public double sum(double num1, double num2) {
                return num1 + num2;
            }
        };
        LOGGER.info("The result of operation is  = " + op.sum(14.5,78.6));

        // anonymous class implementation declarative way
        OperationFunctionalInterface opLambda = (double num1, double num2) -> num1 * num2; // fake implementation for the example
        LOGGER.info("The result of lambda operation is  = " + opLambda.sum(14.5,78.6));
    }

    private static void declarativeApproachWIthMethodReference(List<String> names) {
        Collections.sort(names, String::compareTo);
        LOGGER.info("[declarativeApproachWIthMethodReference] The sorted list is = " + names);
    }

    private static void declarativeApproach(List<String> names) {
        //with lambda expression
        Collections.sort(names, (String name1, String name2) -> name1.compareTo(name2));
        LOGGER.info("[declarativeApproach] The sorted list is = " + names);
    }

    private static void imperativeApproach(List<String> names) {
        // java 7 style
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        LOGGER.info("[imperativeApproach] The sorted list is = " + names);
    }

}
