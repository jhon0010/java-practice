package practice.eight_8.functional;

import org.slf4j.Logger;

import java.util.function.Supplier;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Supplier for results
 */
public class SupplierPractice {

    private static final Logger LOGGER = getLogger(SupplierPractice.class);

    public static void main(String[] args) {

        LOGGER.info(getConnectionUrl());
        LOGGER.info(getConnectionUrlSupplier.get());

    }

    static Supplier<String> getConnectionUrlSupplier = () -> "jdbc://localhost:3306/users";

    static String getConnectionUrl(){
        return "jdbc://132.0.0.75:3306/users";
    }
}
