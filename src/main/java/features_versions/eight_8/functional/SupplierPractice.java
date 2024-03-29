package features_versions.eight_8.functional;

import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * Supplier for results
 */
public class SupplierPractice {

    private static final Logger LOGGER = Logger.getLogger(SupplierPractice.class.getName());

    public static void main(String[] args) {

        LOGGER.info(getConnectionUrl());
        LOGGER.info(getConnectionUrlSupplier.get());

    }

    static Supplier<String> getConnectionUrlSupplier = () -> "jdbc://localhost:3306/users";

    static String getConnectionUrl(){
        return "jdbc://132.0.0.75:3306/users";
    }
}
