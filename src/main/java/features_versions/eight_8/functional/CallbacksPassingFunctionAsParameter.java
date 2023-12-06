package features_versions.eight_8.functional;

import org.slf4j.Logger;

import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

public class CallbacksPassingFunctionAsParameter {

    private static final Logger LOGGER = getLogger(CallbacksPassingFunctionAsParameter.class);


    public static void main(String[] args) {

        greet("Jhon", null, name -> LOGGER.error("No lastname provided for greet " + name));
    }

    public static void greet (String name, String lastName, Consumer<String> callback) {
        LOGGER.info("Greeting " + name);
        if (lastName != null) {
            LOGGER.info("Last name = " + lastName);
        } else {
            callback.accept(name);
        }
    }

}
