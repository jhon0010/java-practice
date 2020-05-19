package practice.defaults;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Main implements Calculator {

    private static final Logger LOGGER = getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Result of default method = " + new Main().sum(10 , 10));
    }

    /**
     * You can override the default behaviour if you want it.
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double sum(double num1, double num2) {
        return 0;
    }

    @Override
    public double substract(double num1, double num2) {
        return 0;
    }
}
