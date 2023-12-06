package features_versions.eight_8.interfaces.defualt.method;

import java.util.logging.Logger;

public class CalculatorImplementation implements CalculatorInterface {

    private static final Logger LOGGER = Logger.getLogger(CalculatorImplementation.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Result of default method = " + new CalculatorImplementation().sum(10 , 10));
    }

    /**
     * You can override the default behaviour if you want it.
     */
    @Override
    public double sum(double num1, double num2) {
        return num1 + num2 + 1; // for some reason.
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
}
